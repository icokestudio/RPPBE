(this["webpackJsonpgogo-react"]=this["webpackJsonpgogo-react"]||[]).push([[9],{373:function(e,t,a){"use strict";a.r(t);var n=a(1),r=a(91),c=a(8),s=a(141),o=a(124),u=a(142),i=a(285),l=a(191),d=a(388),j=a(136),b=a(96),f=a(93),h=a(155),m=a(102),p=a(94),O=a(95),g=a(99),x=a(108),N=a(24);t.default=function(){var e=Object(c.useState)({username:"",password:"",role:"student"}),t=Object(r.a)(e,2),a=t[0],w=t[1],v=Object(c.useState)(!1),S=Object(r.a)(v,2),y=(S[0],S[1],Object(c.useState)(!1)),k=Object(r.a)(y,2),C=k[0],A=k[1],I=Object(c.useContext)(x.context),D=Object(r.a)(I,2),J=D[0],z=D[1],B=function(){C||(A(!0),""!==a.username&&""!==a.password&&g.h(a).then((function(e){"student"===a.role||"course_operator"===a.role?z(Object(n.a)(Object(n.a)({},J),{},{auth:e.data.auth,role:a.role,odata:e.data.data})):z(Object(n.a)(Object(n.a)({},J),{},{auth:btoa("".concat(a.username,":").concat(a.password)),role:a.role,odata:e.data.data})),A(!1),m.b.success("Login successful","Success",1500,null,null,""),"student"===a.role&&g.e(a.username).then((function(t){console.log(t.data),z(Object(n.a)(Object(n.a)({},J),{},{auth:e.data.auth,role:a.role,odata:e.data.data,result:t.data}))})).catch((function(){}))})).catch((function(e){A(!1),m.b.error("Login Failed","Error",2e3,null,null,"")})))};return J.role?Object(N.jsx)(b.a,{to:"/app"}):Object(N.jsx)(s.a,{className:"h-100",children:Object(N.jsx)(p.a,{xxs:"12",md:"10",className:"mx-auto my-auto",children:Object(N.jsxs)(o.a,{className:"auth-card",children:[Object(N.jsxs)("div",{className:"position-relative image-side ",children:[Object(N.jsx)("p",{className:"text-white h2",children:"RESULT PROCESSING MADE EASY"}),Object(N.jsxs)("p",{className:"white mb-0",children:["Please use your credentials to login.",Object(N.jsx)("br",{}),"If you are not registered, please"," ",Object(N.jsx)(f.b,{to:"/user/register",className:"white",children:Object(N.jsx)("u",{children:Object(N.jsx)("b",{children:"register"})})}),"."]})]}),Object(N.jsxs)("div",{className:"form-side",children:[Object(N.jsx)(f.b,{to:"/",className:"white"}),Object(N.jsx)(u.a,{className:"mb-4",children:Object(N.jsx)(O.a,{id:"user.login-title"})}),Object(N.jsx)(h.c,{children:function(e){var t=e.errors,r=e.touched;return Object(N.jsxs)(h.b,{className:"av-tooltip tooltip-label-bottom",children:[Object(N.jsxs)(i.a,{className:"form-group has-float-label",children:[Object(N.jsx)(l.a,{children:"admin"===a.role?"Admin Username":"course_operator"===a.role?"Staff ID":"Matric Number"}),Object(N.jsx)(h.a,{className:"form-control",name:"email",validate:function(){return function(e){var t;return e||(t="Please enter your email address"),t}(a.username)},value:a.username,onChange:function(e){return w(Object(n.a)(Object(n.a)({},a),{},{username:e.target.value}))}}),t.email&&r.email&&Object(N.jsx)("div",{className:"invalid-feedback d-block",children:t.email})]}),Object(N.jsxs)(i.a,{className:"form-group has-float-label",children:[Object(N.jsx)(l.a,{children:Object(N.jsx)(O.a,{id:"user.password"})}),Object(N.jsx)(h.a,{className:"form-control",type:"password",name:"password",value:a.password,validate:function(){return function(e){var t;return e?e.length<8&&(t="Value must be longer than 8 characters"):t="Please enter your password",t}(a.password)},onChange:function(e){return w(Object(n.a)(Object(n.a)({},a),{},{password:e.target.value}))}}),t.password&&r.password&&Object(N.jsx)("div",{className:"invalid-feedback d-block",children:t.password})]}),Object(N.jsx)(d.a,{type:"radio",name:"radiusRadio",id:"student",label:"Student",inline:!0,defaultChecked:"student"===a.role,onChange:function(){return w(Object(n.a)(Object(n.a)({},a),{},{role:"student"}))}}),Object(N.jsx)(d.a,{type:"radio",name:"radiusRadio",id:"course_operator",label:"Course Operator",inline:!0,defaultChecked:"course_operator"===a.role,onChange:function(){return w(Object(n.a)(Object(n.a)({},a),{},{role:"course_operator"}))}}),Object(N.jsx)(d.a,{type:"radio",name:"radiusRadio",id:"admin",label:"Admin",inline:!0,defaultChecked:"admin"===a.role,onChange:function(){return w(Object(n.a)(Object(n.a)({},a),{},{role:"admin"}))}}),Object(N.jsxs)("div",{className:"d-flex justify-content-between align-items-center",children:[Object(N.jsx)(f.b,{to:"/user/forgot-password",children:Object(N.jsx)(O.a,{id:"user.forgot-password-question"})}),Object(N.jsxs)(j.a,{color:"primary",className:"btn-shadow btn-multiple-state ".concat(C?"show-spinner":""),size:"lg",onClick:B,children:[Object(N.jsxs)("span",{className:"spinner d-inline-block",children:[Object(N.jsx)("span",{className:"bounce1"}),Object(N.jsx)("span",{className:"bounce2"}),Object(N.jsx)("span",{className:"bounce3"})]}),Object(N.jsx)("span",{className:"label",children:Object(N.jsx)(O.a,{id:"user.login-button"})})]})]})]})}})]})]})})})}},94:function(e,t,a){"use strict";a.d(t,"a",(function(){return s})),a.d(t,"b",(function(){return o}));var n=a(1),r=(a(8),a(140)),c=a(24),s=function(e){return Object(c.jsx)(r.a,Object(n.a)(Object(n.a)({},e),{},{widths:["xxs","xs","sm","md","lg","xl","xxl"]}))},o=function(e){var t=e.className;return Object(c.jsx)("div",{className:"separator ".concat(t)})}},95:function(e,t,a){"use strict";var n=a(1),r=(a(8),a(157)),c=a(115),s=a(24);t.a=Object(c.c)((function(e){return Object(s.jsx)(r.a,Object(n.a)({},e))}),{withRef:!1})},99:function(e,t,a){"use strict";a.d(t,"h",(function(){return o})),a.d(t,"e",(function(){return u})),a.d(t,"g",(function(){return i})),a.d(t,"q",(function(){return l})),a.d(t,"j",(function(){return d})),a.d(t,"b",(function(){return j})),a.d(t,"l",(function(){return b})),a.d(t,"p",(function(){return f})),a.d(t,"c",(function(){return h})),a.d(t,"d",(function(){return m})),a.d(t,"n",(function(){return p})),a.d(t,"m",(function(){return O})),a.d(t,"o",(function(){return g})),a.d(t,"a",(function(){return x})),a.d(t,"i",(function(){return N})),a.d(t,"k",(function(){return w})),a.d(t,"f",(function(){return v}));var n=a(1),r=a(125),c=a.n(r),s="/api",o=(JSON.parse(sessionStorage.getItem("data")),function(e){if("student"===e.role){var t={matric:e.username,password:e.password,flag:e.role};return c.a.post("".concat(s,"/auth/login"),t)}if("course_operator"===e.role){var a={id:e.username,password:e.password,flag:e.role};return c.a.post("".concat(s,"/auth/login"),a)}return c.a.get("".concat(s,"/auth/login/admin"),{headers:{Authorization:"Basic ".concat(btoa("".concat(e.username,":").concat(e.password)))}})}),u=function(e){return c.a.get("".concat(s,"/student/").concat(e))},i=function(e){return c.a.get("".concat(s,"/student/get/").concat(e))},l=function(){return c.a.get("".concat(s,"/entryyear"))},d=function(e){return"student"===e.role?(delete e.role,delete e.staffId,delete e.status,c.a.post("".concat(s,"/student"),e)):(delete e.role,delete e.matricNumber,delete e.othername,delete e.yearOfEntry,delete e.status,c.a.post("".concat(s,"/courseoperator"),e))},j=function(e,t){return c.a.get("".concat(s,"/result/").concat(e,"/").concat(t))},b=function(e){return c.a.post("".concat(s,"/result"),e)},f=function(e){var t={headers:{Authorization:"Bearer ".concat(JSON.parse(sessionStorage.getItem("data")).auth)}};return c.a.post("".concat(s,"/result/course/upload"),e,t)},h=function(){return c.a.get("".concat(s,"/courseoperator"))},m=function(e){return c.a.get("".concat(s,"/courseoperator/").concat(e,"/student"),{responseType:"blob"})},p=function(e){return c.a.post("".concat(s,"/course"),e)},O=function(e){return c.a.post("".concat(s,"/courseoperator/allocate"),e)},g=function(e){return c.a.post("".concat(s,"/currentsession/course/upload"),e)},x=function(e){var t=Object(n.a)(Object(n.a)({},e),{},{startDate:Date.parse(e.startDate),closeDate:Date.parse(e.closeDate)});return c.a.post("".concat(s,"/currentsession"),t,{headers:{Authorization:"Basic ".concat(JSON.parse(sessionStorage.getItem("data")).auth)}})},N=function(e){return c.a.put("".concat(s,"/currentsession/").concat(e),{headers:{Authorization:"Basic ".concat(JSON.parse(sessionStorage.getItem("data")).auth)}})},w=function(){return c.a.get("".concat(s,"/auth/login/admin"),{headers:{Authorization:"Basic ".concat(JSON.parse(sessionStorage.getItem("data")).auth)}})},v=function(e,t){return c.a.get("".concat(s,"/auth/result/").concat(e,"/").concat(t),{headers:{Authorization:"Basic ".concat(JSON.parse(sessionStorage.getItem("data")).auth)}})}}}]);