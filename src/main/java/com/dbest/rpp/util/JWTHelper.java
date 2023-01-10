/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.util;


import com.dbest.rpp.entity.CourseOperator;
import com.dbest.rpp.entity.Student;
import com.dbest.rpp.session.CourseOperatorFacade;
import com.dbest.rpp.session.StudentFacade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ftadewale
 */

@Stateless
public class JWTHelper {
    
    @EJB
    CourseOperatorFacade cof;
    
    @EJB
    StudentFacade sf;

    public String generateToken(Map<String, String> payload) {
        
        //openssl rand -base64 172 | tr -d '\n'
        //String tokenKey="4djbRJAQuB1AN9Nmg8l3rBus1o99uxbDDMtMhmODClSt1FHOvYBqLmoTSm8t0OVX1qKsfexgGiE2+AYjv/DReJFSsFurTFDXfZydI/696MmOoI50aBbgVCfFFnAOxXJ+knm4BXeMs6f2RSzRCRnk2dxczYgsBgiYtU1eDHJkRL6l1Q59q50CH1Hsq+K+DKhFFrVP2rEck/6/16HMZ1Vv6IWUDx4vw7z2sXnbhA==";
        Map<String, Object> tokenData = new HashMap<>();
        
        String id = payload.get("id");
        if(id==null) payload.get("matric");
        String flag = payload.getOrDefault("flag", "student");
        
        // User Personal Information
        tokenData.put("pk", id);
        tokenData.put("flag", flag);
        
        // Token Expiration
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, flag.equals("courseoperator") ? 5 : 2);
        tokenData.put("expires", calendar.getTime());
        
        // Build Token
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS256, Secret.getSecret()).compact();
    }
    
    public Map<String, Object> getUser(String data)
    {
        Map<String, Object> payload = new HashMap();
        
        int i = data.lastIndexOf('.');
        String withoutSignature = data.substring(0, i+1);
        Jwt<Header,Claims> untrusted = Jwts.parser().parseClaimsJwt(withoutSignature);

        String userId = untrusted.getBody().get("pk").toString();
        String flag = ""+untrusted.getBody().get("flag");
        
        if(flag.equals("course_operator")){
            CourseOperator co = cof.findByStaffId(userId);
            payload.put("courseoperator", co);
            payload.put("pk", co.getStaffId());
        } else {
            Student student = sf.find(userId);
            payload.put("student", student);
        }
        
        return payload;
    }
    
   
    public Map<String, String> validateToken(String token) { 
        
        Map<String, String> payload= new HashMap();
        String message = "";
        
        try{
            Map<String, Object> data = getUser(token);
            Object student = data.getOrDefault("student", null);
            Object courseoperator = data.getOrDefault("courseoperator", null);
            
            boolean isStudent = student != null;
            boolean isCourseOperator = courseoperator != null;
            
            Student student1 = isStudent ? (Student)student : null;
            CourseOperator courseoperator1 = isCourseOperator ? (CourseOperator)courseoperator : null;
            
            boolean studentActive = isStudent ? !student1.getIsBlocked(): false;
            boolean courseOperatorActive = isCourseOperator ?courseoperator1.getIsBlocked() : false;
            
            if(!isStudent&&!isCourseOperator){
                message="Invalid credentials";
            }
            else{
                String secret = Secret.getSecret();
                Claims claims = Jwts.parser()         
               .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
               .parseClaimsJws(token).getBody();

                long expires = (long)claims.get("expires");
                Date expired = new Date(expires);
                Date today = new Date();
                if (today.after(expired))
                {
                    message = "Authentication Credentials has expired. Please Try and login again.";
                } else message = "valid";

            }
            
            payload.put("flag", isStudent ? "student" : "courseoperator");

        }catch(Exception ee){;
            ee.printStackTrace();
            message = "Invalid Authentication Credentials";
        }
        
        
        payload.put("message", message);
        return payload;
    }
}
