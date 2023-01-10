package com.dbest.rpp.util;

import com.dbest.rpp.entity.CurrentSession;
import com.dbest.rpp.entity.Result;
import com.dbest.rpp.entity.Semester;
import com.dbest.rpp.session.ResultFacade;
import com.dbest.rpp.session.SemesterFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author felix
 */
@Stateless
public class ResultProcessor {
    @EJB
    private ResultFacade resultFacade;
    @EJB
    private SemesterFacade smf;        
    Map<String,Object> y1 = new LinkedHashMap<>();
    
    private Set<CurrentSession> getStudentActiveSessions(List<Result> result){
        Set<CurrentSession> sessions= new HashSet<>();
        for(Result r: result){
            sessions.add(r.getSession());
        }
        return sessions;
    }
    public Map<String,Object> distinguishSession(List<Result> result){
        Map<String,Object> results = new LinkedHashMap<>();
        for(CurrentSession cs:getStudentActiveSessions(result)){
            results.put(cs.getSession().getSession(), resultCollator(result,cs));
        }
        return results;
    }

    private Object resultCollator(List<Result> result, CurrentSession cs) {
        List<Result> results = new ArrayList<>();
        result.stream().filter(r -> (r.getSession()==cs)).forEachOrdered(r -> {
            results.add(r);
        });
        List<Semester> semesters = smf.findAll();
        for(Semester semester:semesters){
               List<Result> semesterResults = new ArrayList<>();
               int tnu=0;
               int tcp=0;
               double gpa=0;
            for(Result resultt:results){
                if(Objects.equals(resultt.getSemester().getId(), semester.getId())) {
                    semesterResults.add(resultt);
                    tnu=tnu+resultt.getCourse().getCourseUnit();
                    tcp=tcp+resultFacade.getGP(resultt);
                    if(tnu!=0){
                        gpa=(double)tcp/(double)tnu;
                    }
                }
            }
            y1.put(semester.getName(), semesterResults);
             y1.put(semester.getName()+"tnu", tnu);
            y1.put(semester.getName()+"tcp", tcp);
            y1.put(semester.getName()+"gpa", gpa);
        }
        return y1;
    }
}
