/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.util;

/**
 *
 * @author felix
 */
public class HelperFunc implements Constants {
    
    public static String emailGenerator(String user,String link,String value,String type){
        String out = emailText();
        out = out.replaceAll("-SALUTE-", "Dear "+ user);
        out = out.replaceAll("-BODY3-", "kind Regards, <p><b>Course Operator Team</b></p>");
        if(!link.isEmpty()) out = out.replaceAll("-BODY2-", "<a href="+link+">click here</a>");
        else out = out.replaceAll("-BODY2-", "");
        if(type.equals(COURSE_ALLOCATION)){
               out= out.replaceAll("-BODY-", "Good day. Please be notified that you have been allocated <b>" +value+ "</b> to take. You shall also be responsible for the upload of the result"); 
               return out;
        }
         if(type.equals(RESULT_NOTIFICATION)){
               out = out.replaceAll("-BODY-", "Good day. Please be notified that  ( "+value +" ) result has just been uploaded."); 
               return out;
         } 
         if(type.equals(STUDENT_ACCOUNT_CREATION)){
               out = out.replaceAll("-BODY-", "Good day. Your student account creation was successful."); 
               return out;
         }
         if(type.equals(COURSE_OPERATOR_ACCOUNT_CREATION)){
               out = out.replaceAll("-BODY-", "Good day. Your course operator account creation was successful"); 
               return out;
         }
         if(type.equals(RESULT_UPLOAD_OPENING_NOTIFICATION)){
               out = out.replaceAll("-BODY-", "Good day. Please be notified that the result upload portal is now available. ( "+value +" )"); 
               return out;
         }
         if(type.equals(FORGET_PASSWORD)){
               out = out.replaceAll("-BODY-", "Your new password is "+value+" . Please be sure to change it immediately. Click on the link below to get started"); 
               return out;
         }
        return out;
    }    
    private static String emailText(){
       return "<!DOCTYPE html>\n" +
"<html>\n" +
"  <head>\n" +
"    <meta name=\"viewport\" content=\"width=device-width\" />\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"    <title>-TITLE-</title>\n" +
"    <style>\n" +
"      /* -------------------------------------\n" +
"        INLINED WITH htmlemail.io/inline\n" +
"    ------------------------------------- */\n" +
"      /* -------------------------------------\n" +
"        RESPONSIVE AND MOBILE FRIENDLY STYLES\n" +
"    ------------------------------------- */\n" +
"      @media only screen and (max-width: 620px) {\n" +
"        table[class='body'] h1 {\n" +
"          font-size: 28px !important;\n" +
"          margin-bottom: 10px !important;\n" +
"        }\n" +
"        table[class='body'] p,\n" +
"        table[class='body'] ul,\n" +
"        table[class='body'] ol,\n" +
"        table[class='body'] td,\n" +
"        table[class='body'] span,\n" +
"        table[class='body'] a {\n" +
"          font-size: 16px !important;\n" +
"        }\n" +
"        table[class='body'] .wrapper,\n" +
"        table[class='body'] .article {\n" +
"          padding: 10px !important;\n" +
"        }\n" +
"        table[class='body'] .content {\n" +
"          padding: 0 !important;\n" +
"        }\n" +
"        table[class='body'] .container {\n" +
"          padding: 0 !important;\n" +
"          width: 100% !important;\n" +
"        }\n" +
"        table[class='body'] .main {\n" +
"          border-left-width: 0 !important;\n" +
"          border-radius: 0 !important;\n" +
"          border-right-width: 0 !important;\n" +
"        }\n" +
"        table[class='body'] .btn table {\n" +
"          width: 100% !important;\n" +
"        }\n" +
"        table[class='body'] .btn a {\n" +
"          width: 100% !important;\n" +
"        }\n" +
"        table[class='body'] .img-responsive {\n" +
"          height: auto !important;\n" +
"          max-width: 100% !important;\n" +
"          width: auto !important;\n" +
"        }\n" +
"      }\n" +
"\n" +
"      /* -------------------------------------\n" +
"        PRESERVE THESE STYLES IN THE HEAD\n" +
"    ------------------------------------- */\n" +
"      @media all {\n" +
"        .ExternalClass {\n" +
"          width: 100%;\n" +
"        }\n" +
"        .ExternalClass,\n" +
"        .ExternalClass p,\n" +
"        .ExternalClass span,\n" +
"        .ExternalClass font,\n" +
"        .ExternalClass td,\n" +
"        .ExternalClass div {\n" +
"          line-height: 100%;\n" +
"        }\n" +
"        .apple-link a {\n" +
"          color: inherit !important;\n" +
"          font-family: inherit !important;\n" +
"          font-size: inherit !important;\n" +
"          font-weight: inherit !important;\n" +
"          line-height: inherit !important;\n" +
"          text-decoration: none !important;\n" +
"        }\n" +
"        #MessageViewBody a {\n" +
"          color: inherit;\n" +
"          text-decoration: none;\n" +
"          font-size: inherit;\n" +
"          font-family: inherit;\n" +
"          font-weight: inherit;\n" +
"          line-height: inherit;\n" +
"        }\n" +
"        .btn-primary table td:hover {\n" +
"          background-color: #34495e !important;\n" +
"        }\n" +
"        .btn-primary a:hover {\n" +
"          background-color: #34495e !important;\n" +
"          border-color: #34495e !important;\n" +
"        }\n" +
"      }\n" +
"    </style>\n" +
"  </head>\n" +
"  <body\n" +
"    class=\"\"\n" +
"    style=\"\n" +
"      background-color: #f6f6f6;\n" +
"      font-family: sans-serif;\n" +
"      -webkit-font-smoothing: antialiased;\n" +
"      font-size: 14px;\n" +
"      line-height: 1.4;\n" +
"      margin: 0;\n" +
"      padding: 0;\n" +
"      -ms-text-size-adjust: 100%;\n" +
"      -webkit-text-size-adjust: 100%;\n" +
"    \"\n" +
"  >\n" +
"    <table\n" +
"      border=\"0\"\n" +
"      cellpadding=\"0\"\n" +
"      cellspacing=\"0\"\n" +
"      class=\"body\"\n" +
"      style=\"\n" +
"        border-collapse: separate;\n" +
"        mso-table-lspace: 0pt;\n" +
"        mso-table-rspace: 0pt;\n" +
"        width: 100%;\n" +
"        background-color: #f6f6f6;\n" +
"      \"\n" +
"    >\n" +
"      <tr>\n" +
"        <td\n" +
"          style=\"font-family: sans-serif; font-size: 14px; vertical-align: top\"\n" +
"        >\n" +
"          &nbsp;\n" +
"        </td>\n" +
"        <td\n" +
"          class=\"container\"\n" +
"          style=\"\n" +
"            font-family: sans-serif;\n" +
"            font-size: 14px;\n" +
"            vertical-align: top;\n" +
"            display: block;\n" +
"            margin: 0 auto;\n" +
"            max-width: 580px;\n" +
"            padding: 10px;\n" +
"            width: 580px;\n" +
"          \"\n" +
"        >\n" +
"          <div\n" +
"            class=\"content\"\n" +
"            style=\"\n" +
"              box-sizing: border-box;\n" +
"              display: block;\n" +
"              margin: 0 auto;\n" +
"              max-width: 580px;\n" +
"              padding: 10px;\n" +
"            \"\n" +
"          >\n" +
"            <!-- START CENTERED WHITE CONTAINER -->\n" +
"            <span\n" +
"              class=\"preheader\"\n" +
"              style=\"\n" +
"                color: transparent;\n" +
"                display: none;\n" +
"                height: 0;\n" +
"                max-height: 0;\n" +
"                max-width: 0;\n" +
"                opacity: 0;\n" +
"                overflow: hidden;\n" +
"                mso-hide: all;\n" +
"                visibility: hidden;\n" +
"                width: 0;\n" +
"              \"\n" +
"              >This is preheader text. Some clients will show this text as a\n" +
"              preview.</span\n" +
"            >\n" +
"            <table\n" +
"              class=\"main\"\n" +
"              style=\"\n" +
"                border-collapse: separate;\n" +
"                mso-table-lspace: 0pt;\n" +
"                mso-table-rspace: 0pt;\n" +
"                width: 100%;\n" +
"                background: #ffffff;\n" +
"                border-radius: 3px;\n" +
"              \"\n" +
"            >\n" +
"              <!-- START MAIN CONTENT AREA -->\n" +
"              <tr>\n" +
"                <td\n" +
"                  class=\"wrapper\"\n" +
"                  style=\"\n" +
"                    font-family: sans-serif;\n" +
"                    font-size: 14px;\n" +
"                    vertical-align: top;\n" +
"                    box-sizing: border-box;\n" +
"                    padding: 20px;\n" +
"                  \"\n" +
"                >\n" +
"                  <table\n" +
"                    border=\"0\"\n" +
"                    cellpadding=\"0\"\n" +
"                    cellspacing=\"0\"\n" +
"                    style=\"\n" +
"                      border-collapse: separate;\n" +
"                      mso-table-lspace: 0pt;\n" +
"                      mso-table-rspace: 0pt;\n" +
"                      width: 100%;\n" +
"                    \"\n" +
"                  >\n" +
"                    <tr>\n" +
"                      <td\n" +
"                        style=\"\n" +
"                          font-family: sans-serif;\n" +
"                          font-size: 14px;\n" +
"                          vertical-align: top;\n" +
"                        \"\n" +
"                      >\n" +
"                        <p\n" +
"                          style=\"\n" +
"                            font-family: sans-serif;\n" +
"                            font-size: 14px;\n" +
"                            font-weight: normal;\n" +
"                            margin: 0;\n" +
"                            margin-bottom: 15px;\n" +
"                          \"\n" +
"                        >\n" +
"                          -SALUTE-,\n" +
"                        </p>\n" +
"                        <p\n" +
"                          style=\"\n" +
"                            font-family: sans-serif;\n" +
"                            font-size: 14px;\n" +
"                            font-weight: normal;\n" +
"                            margin: 0;\n" +
"                            margin-bottom: 15px;\n" +
"                          \"\n" +
"                        >\n" +
"                          -BODY-.\n" +
"                        </p>\n" +
"                        <p\n" +
"                          style=\"\n" +
"                            font-family: sans-serif;\n" +
"                            font-size: 14px;\n" +
"                            font-weight: normal;\n" +
"                            margin: 0;\n" +
"                            margin-bottom: 15px;\n" +
"                          \"\n" +
"                        >\n" +
"                          -BODY2-\n" +
"                        </p>\n" +
"                        <p\n" +
"                          style=\"\n" +
"                            font-family: sans-serif;\n" +
"                            font-size: 14px;\n" +
"                            font-weight: normal;\n" +
"                            margin: 0;\n" +
"                            margin-bottom: 15px;\n" +
"                          \"\n" +
"                        >\n" +
"                          -BODY3-.\n" +
"                        </p>\n" +
"                      </td>\n" +
"                    </tr>\n" +
"                  </table>\n" +
"                </td>\n" +
"              </tr>\n" +
"\n" +
"              <!-- END MAIN CONTENT AREA -->\n" +
"            </table>\n" +
"\n" +
"            <!-- START FOOTER -->\n" +
"            <div\n" +
"              class=\"footer\"\n" +
"              style=\"\n" +
"                clear: both;\n" +
"                margin-top: 10px;\n" +
"                text-align: center;\n" +
"                width: 100%;\n" +
"              \"\n" +
"            >\n" +
"              <table\n" +
"                border=\"0\"\n" +
"                cellpadding=\"0\"\n" +
"                cellspacing=\"0\"\n" +
"                style=\"\n" +
"                  border-collapse: separate;\n" +
"                  mso-table-lspace: 0pt;\n" +
"                  mso-table-rspace: 0pt;\n" +
"                  width: 100%;\n" +
"                \"\n" +
"              >\n" +
"                <tr>\n" +
"                  <td\n" +
"                    class=\"content-block\"\n" +
"                    style=\"\n" +
"                      font-family: sans-serif;\n" +
"                      vertical-align: top;\n" +
"                      padding-bottom: 10px;\n" +
"                      padding-top: 10px;\n" +
"                      font-size: 12px;\n" +
"                      color: #999999;\n" +
"                      text-align: center;\n" +
"                    \"\n" +
"                  >\n" +
"                    <span\n" +
"                      class=\"apple-link\"\n" +
"                      style=\"\n" +
"                        color: #999999;\n" +
"                        font-size: 12px;\n" +
"                        text-align: center;\n" +
"                      \"\n" +
"                      ></span\n" +
"                    >\n" +
"                  </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                  <td\n" +
"                    class=\"content-block powered-by\"\n" +
"                    style=\"\n" +
"                      font-family: sans-serif;\n" +
"                      vertical-align: top;\n" +
"                      padding-bottom: 10px;\n" +
"                      padding-top: 10px;\n" +
"                      font-size: 12px;\n" +
"                      color: #999999;\n" +
"                      text-align: center;\n" +
"                    \"\n" +
"                  >\n" +
"                    Powered by\n" +
"                    <b>Course Operator Systems</b>.\n" +
"                  </td>\n" +
"                </tr>\n" +
"              </table>\n" +
"            </div>\n" +
"            <!-- END FOOTER -->\n" +
"\n" +
"            <!-- END CENTERED WHITE CONTAINER -->\n" +
"          </div>\n" +
"        </td>\n" +
"        <td\n" +
"          style=\"font-family: sans-serif; font-size: 14px; vertical-align: top\"\n" +
"        >\n" +
"          &nbsp;\n" +
"        </td>\n" +
"      </tr>\n" +
"    </table>\n" +
"  </body>\n" +
"</html>";
    }
    
}
