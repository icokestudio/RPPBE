(this["webpackJsonpgogo-react"]=this["webpackJsonpgogo-react"]||[]).push([[6],{106:function(e,t,r){"use strict";r(8);var o=r(261),c=r(262),a=r(93),n=r(95),l=r(11),s=r(24),i=function(e){return"/".concat(e)===l.a?Object(s.jsx)(n.a,{id:"menu.home"}):Object(s.jsx)(n.a,{id:"menu.".concat(e)})},d=function(e,t){return e.split(t)[0]+t},h=function(e){var t=e.match.path.substr(1),r=t.split("/");return r[r.length-1].indexOf(":")>-1&&(r=r.filter((function(e){return-1===e.indexOf(":")}))),Object(s.jsx)(s.Fragment,{children:Object(s.jsx)(o.a,{className:"pt-0 breadcrumb-container d-none d-sm-block d-lg-inline-block",children:r.map((function(e,o){return Object(s.jsx)(c.a,{active:r.length===o+1,children:r.length!==o+1?Object(s.jsx)(a.b,{to:"/".concat(d(t,e)),children:i(e)}):i(e)},o)}))})})};t.a=function(e){var t=e.heading,r=e.match;return Object(s.jsxs)(s.Fragment,{children:[t&&Object(s.jsx)("h1",{children:Object(s.jsx)(n.a,{id:t})}),Object(s.jsx)(h,{match:r})]})}},210:function(e,t,r){"use strict";var o=r(132),c=(r(8),r(86)),a=r.n(c),n=r(24);t.a=function(e){var t=e.data,r=["Course Code","Course Unit","Score","Grade"],c=function(e){for(var r=[],c=0,a=Object.keys(t);c<a.length;c++){var n=a[c];n.includes(e)&&!Array.isArray(t[n])&&(r=[].concat(Object(o.a)(r),[t[n]]))}return r};return Object(n.jsx)(n.Fragment,{children:function(e){for(var t=[],r=0,c=Object.keys(e);r<c.length;r++){var a=c[r];Array.isArray(e[a])&&e[a].length>0&&(t=[].concat(Object(o.a)(t),[[a,e[a]]]))}return t}(t).map((function(e){return Object(n.jsxs)(n.Fragment,{children:[Object(n.jsx)("h4",{children:e[0]}),Object(n.jsxs)("table",{className:"r-table table ".concat(a()({"table-divided":!0})),children:[Object(n.jsx)("thead",{children:Object(n.jsx)("tr",{children:r.map((function(e){return Object(n.jsx)("th",{className:"sorted-asc",children:e})}))})}),Object(n.jsx)("tbody",{children:e[1].map((function(e){return Object(n.jsxs)("tr",{children:[Object(n.jsx)("td",{children:e.course.courseCode}),Object(n.jsx)("td",{children:e.course.courseUnit}),Object(n.jsx)("td",{children:e.total}),Object(n.jsx)("td",{children:e.grade})]})}))})]}),Object(n.jsxs)("span",{className:"m-4 ",children:["Semester Units:  ",c(e[0])[0]]}),Object(n.jsxs)("span",{className:"m-4",children:["Semester Grade Points:  ",c(e[0])[1]]}),Object(n.jsxs)("span",{className:"m-4",children:["Semetser GPA:  ",c(e[0])[2]]}),Object(n.jsx)("br",{}),Object(n.jsx)("h1",{})]})}))})}},344:function(e,t,r){"use strict";r.r(t);var o=r(91),c=r(8),a=r(141),n=r(94),l=r(106),s=r(108),i=r(210),d=r(24);t.default=function(e){var t=e.match,r=Object(c.useContext)(s.context),h=Object(o.a)(r,2),j=h[0];h[1];return Object(d.jsxs)(d.Fragment,{children:[Object(d.jsx)(a.a,{children:Object(d.jsxs)(n.a,{xxs:"12",children:[Object(d.jsx)(l.a,{heading:"menu.second2",match:t}),Object(d.jsx)(n.b,{className:"mb-5"})]})}),Object(d.jsx)(a.a,{children:Object(d.jsx)(n.a,{xxs:"12",className:"mb-4"})}),function(e){return Object.entries(e.result).filter((function(e){var t=Object(o.a)(e,2),r=t[0];t[1];return"string"===typeof r&&r.includes("/")}))}(j).map((function(e){return Object(d.jsxs)(d.Fragment,{children:[" ",Object(d.jsx)("h3",{children:Object(d.jsx)("b",{children:e[0]})}),Object(d.jsx)(i.a,{data:e[1]})]})})),Object(d.jsx)("div",{className:"float-right",children:Object(d.jsx)("h6",{children:Object(d.jsx)("b",{children:"Total Unit: ".concat(j.odata.tnu,"  Total Grade Points: ").concat(j.odata.tgp," CGPA: ").concat(j.odata.cgpa)})})})]})}},345:function(e,t,r){"use strict";r.r(t);var o=r(91),c=r(8),a=r(141),n=r(94),l=r(106),s=r(108),i=r(210),d=r(24);t.default=function(e){var t=e.match,r=Object(c.useContext)(s.context),h=Object(o.a)(r,2),j=h[0];h[1];return Object(d.jsxs)(d.Fragment,{children:[Object(d.jsx)(a.a,{children:Object(d.jsxs)(n.a,{xxs:"12",children:[Object(d.jsx)(l.a,{heading:"menu.second2",match:t}),Object(d.jsx)(n.b,{className:"mb-5"})]})}),Object(d.jsx)(a.a,{children:Object(d.jsx)(n.a,{xxs:"12",className:"mb-4"})}),function(e){return Object.entries(e.result).filter((function(e){var t=Object(o.a)(e,2),r=t[0];t[1];return"string"===typeof r&&r.includes("/")}))}(j).map((function(e){return Object(d.jsxs)(d.Fragment,{children:[" ",Object(d.jsx)("h3",{children:Object(d.jsx)("b",{children:e[0]})}),Object(d.jsx)(i.a,{data:e[1]})]})})),Object(d.jsx)("h6",{children:Object(d.jsxs)("b",{children:["CGPA: ",j.odata.cgpa]})})]})}},347:function(e,t,r){"use strict";r.r(t);var o=r(1),c=r(132),a=r(91),n=r(8),l=r.n(n),s=r(141),i=function(){var e=getComputedStyle(document.body);return{themeColor1:e.getPropertyValue("--theme-color-1").trim(),themeColor2:e.getPropertyValue("--theme-color-2").trim(),themeColor3:e.getPropertyValue("--theme-color-3").trim(),themeColor4:e.getPropertyValue("--theme-color-4").trim(),themeColor5:e.getPropertyValue("--theme-color-5").trim(),themeColor6:e.getPropertyValue("--theme-color-6").trim(),themeColor1_10:e.getPropertyValue("--theme-color-1-10").trim(),themeColor2_10:e.getPropertyValue("--theme-color-2-10").trim(),themeColor3_10:e.getPropertyValue("--theme-color-3-10").trim(),themeColor4_10:e.getPropertyValue("--theme-color-3-10").trim(),themeColor5_10:e.getPropertyValue("--theme-color-3-10").trim(),themeColor6_10:e.getPropertyValue("--theme-color-3-10").trim(),primaryColor:e.getPropertyValue("--primary-color").trim(),foregroundColor:e.getPropertyValue("--foreground-color").trim(),separatorColor:e.getPropertyValue("--separator-color").trim()}},d=r(94),h=r(106),j=r(108),m=r(124),b=r(295),u=r(377),x=r(378),O=r(93),C=(r(95),r(86)),f=r.n(C),g=r(24),p=function(e){var t=e.text,r=e.color,o=e.className,c=e.rounded,a=e.small,n="";return t.indexOf(" ")>-1?t.split(" ").map((function(e){return e.length>1&&(n+=e.slice(0,1)),""})):n+=t.slice(0,2),n.length>2&&(n=n.slice(0,2)),Object(g.jsx)("div",{className:"align-self-center list-thumbnail-letters ".concat(r?"btn-".concat(r):"","  ").concat(o,"  ").concat(f()({"rounded-circle":c,small:a})),title:t,children:n})},v=l.a.memo(p),y=function(e){var t=e.data;return Object(g.jsx)(s.a,{children:Object(g.jsx)(d.a,{xxs:"12",children:Object(g.jsxs)(s.a,{children:[Object(g.jsx)(d.a,{md:"6",sm:"6",lg:"4",xxs:"12",children:Object(g.jsx)(m.a,{className:"mb-4",children:Object(g.jsx)(b.a,{children:Object(g.jsxs)("div",{className:"text-center",children:[Object(g.jsx)("center",{children:Object(g.jsx)(v,{rounded:!0,text:"".concat(t.odata.firstname," ").concat(t.odata.lastname),className:"img-thumbnail mb-4"})}),Object(g.jsx)(O.b,{to:"#",children:Object(g.jsx)(u.a,{className:"mb-1",children:Object(g.jsxs)("b",{children:[t.odata.firstname," ",t.odata.othername,t.odata.lastname," "]})})}),Object(g.jsx)(x.a,{className:"text-muted text-small mb-1",children:t.odata.matricNumber}),Object(g.jsx)(x.a,{className:"text-muted text-small mb-4",children:"Student"})]})})})}),Object(g.jsx)(d.a,{md:"6",sm:"6",lg:"4",xxs:"12",children:Object(g.jsx)(m.a,{className:"mb-4",children:Object(g.jsx)("div",{className:" d-flex flex-grow-1 min-width-zero",children:Object(g.jsx)(b.a,{className:" pl-0 align-self-center d-flex flex-column flex-lg-row justify-content-between min-width-zero",children:Object(g.jsxs)("div",{className:"min-width-zero",children:[Object(g.jsx)(O.b,{to:"#",children:Object(g.jsx)(u.a,{className:"text-center",children:Object(g.jsx)("h3",{children:Object(g.jsx)("b",{children:"Cummulative Grade Point Average (CGPA)"})})})}),Object(g.jsx)(x.a,{className:"text-muted text-small mb-2",children:Object(g.jsx)("center",{children:Object(g.jsx)("h6",{children:t.odata.cgpa})})})]})})})})}),Object(g.jsx)(d.a,{md:"6",sm:"6",lg:"4",xxs:"12",children:Object(g.jsx)(m.a,{className:"mb-4",children:Object(g.jsx)("div",{className:" d-flex flex-grow-1 min-width-zero",children:Object(g.jsx)(b.a,{className:" pl-0 align-self-center d-flex flex-column flex-lg-row justify-content-between min-width-zero",children:Object(g.jsxs)("div",{className:"min-width-zero",children:[Object(g.jsx)(O.b,{to:"#",children:Object(g.jsx)(u.a,{className:"text-center",children:Object(g.jsx)("h3",{children:Object(g.jsx)("b",{children:"Student Addmission Year/Entry Year"})})})}),Object(g.jsx)(x.a,{className:"text-muted text-small mb-2",children:Object(g.jsx)("center",{children:Object(g.jsx)("h6",{children:t.odata.yearOfEntry.session.session})})})]})})})})})]})})})},N=r(104),w={backgroundColor:i().foregroundColor,titleFontColor:i().primaryColor,borderColor:i().separatorColor,borderWidth:.5,bodyFontColor:i().primaryColor,bodySpacing:10,xPadding:15,yPadding:15,cornerRadius:.15},P={legend:{display:!1},responsive:!0,maintainAspectRatio:!1,tooltips:w,scales:{yAxes:[{gridLines:{display:!0,lineWidth:1,color:"rgba(0,0,0,0.1)",drawBorder:!1},ticks:{beginAtZero:!0,stepSize:1,min:0,max:7,padding:20}}],xAxes:[{gridLines:{display:!1}}]}},_=function(e){var t=e.data,r=e.shadow,o=void 0!==r&&r,c=Object(n.useRef)(null),l=Object(n.useState)(null),s=Object(a.a)(l,2)[1];return Object(n.useEffect)((function(){if(c&&c.current){o&&(N.Chart.defaults.lineWithShadow=N.Chart.defaults.line,N.Chart.controllers.lineWithShadow=N.Chart.controllers.line.extend({draw:function(e){N.Chart.controllers.line.prototype.draw.call(this,e);var t=this.chart.ctx;t.save(),t.shadowColor="rgba(0,0,0,0.15)",t.shadowBlur=10,t.shadowOffsetX=0,t.shadowOffsetY=10,t.responsive=!0,t.stroke(),N.Chart.controllers.line.prototype.draw.apply(this,arguments),t.restore()}}));var e=c.current.getContext("2d"),r=new N.Chart(e,{type:o?"lineWithShadow":"line",options:P,data:t});s(r)}}),[c,t,o]),Object(g.jsx)("canvas",{ref:c})},A=i(),S=(A.themeColor1,A.foregroundColor,A.themeColor1,A.themeColor1,A.foregroundColor,A.themeColor1,A.themeColor2,A.themeColor3,A.themeColor1_10,A.themeColor2_10,A.themeColor3_10,A.themeColor1,A.foregroundColor,A.themeColor1,A.themeColor1,A.foregroundColor,A.themeColor1_10,A.themeColor1,A.themeColor1_10,A.themeColor2,A.themeColor2_10,A.themeColor1,A.themeColor1_10,A.themeColor2,A.themeColor2_10,A.themeColor1,A.themeColor1,A.themeColor1_10,A.themeColor2,A.themeColor2,A.themeColor2_10,A.themeColor1,A.themeColor2,A.themeColor3,A.themeColor1_10,A.themeColor2_10,A.themeColor3_10,A.themeColor3,A.themeColor2,A.themeColor1,A.themeColor3_10,A.themeColor2_10,A.themeColor1_10,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor1,A.themeColor2,A.foregroundColor,A.themeColor2,A.themeColor2,A.foregroundColor,A.themeColor2_10,function(e){var t=e.data;return Object(g.jsxs)(m.a,{className:"dashboard-filled-line-chart",children:[Object(g.jsx)(b.a,{children:Object(g.jsx)("div",{className:"float-left float-none-xs",children:Object(g.jsx)("div",{className:"d-inline-block",children:Object(g.jsx)("h5",{className:"d-inline",children:"CGPA Chart"})})})}),Object(g.jsx)("div",{className:"chart card-body pt-0",children:Object(g.jsx)(_,{shadow:!0,data:t})})]})}),k=i();t.default=function(e){var t=e.match,r=Object(n.useState)(""),l=Object(a.a)(r,2),i=(l[0],l[1],Object(n.useState)(0)),m=Object(a.a)(i,2),b=(m[0],m[1],Object(n.useState)(0)),u=Object(a.a)(b,2),x=(u[0],u[1],Object(n.useState)({labels:[],datasets:[{label:"",data:null,borderColor:k.themeColor2,pointBackgroundColor:k.foregroundColor,pointBorderColor:k.themeColor2,pointHoverBackgroundColor:k.themeColor2,pointHoverBorderColor:k.foregroundColor,pointRadius:4,pointBorderWidth:2,pointHoverRadius:5,fill:!0,borderWidth:2,backgroundColor:k.themeColor2_10}]})),O=Object(a.a)(x,2),C=O[0],f=O[1],p=Object(n.useState)("hi"),v=Object(a.a)(p,2),N=v[0],w=v[1],P=Object(n.useContext)(j.context),_=Object(a.a)(P,2),A=_[0],V=(_[1],function(e,t){for(var r=0,o=0,c=0;c<t;c++)r+=e[c],o+=e[c+1];return o/r});return Object(n.useEffect)((function(){var e=function(){for(var e=[],t=[],r=[],o=0,a=Object.keys(A.result);o<a.length;o++){for(var n=a[o],l=0,s=Object.keys(A.result["".concat(n)]);l<s.length;l++){var i=s[l];Array.isArray(A.result["".concat(n)]["".concat(i)])&&A.result["".concat(n)]["".concat(i)].length>0&&(e=[].concat(Object(c.a)(e),[i])),i.includes(e[e.length-1])&&i!==e[e.length-1]&&(t=[].concat(Object(c.a)(t),[A.result["".concat(n)]["".concat(i)]]))}t.splice(-1)}for(var d=1;d<=e.length;d++)r=[].concat(Object(c.a)(r),[V(t,d)]);return[e,r]}();w((function(){return function(){var e=(new Date).getHours();return e<12?"Good Morning":e>12&&e<16?"Good Afternoon":"Good Evening"}()})),f(Object(o.a)(Object(o.a)({},C),{},{labels:e[0],datasets:[Object(o.a)(Object(o.a)({},C.datasets[0]),{},{data:e[1]})]}))}),[]),Object(g.jsxs)(g.Fragment,{children:[Object(g.jsx)(s.a,{children:Object(g.jsxs)(d.a,{xxs:"12",children:[Object(g.jsx)(h.a,{heading:"menu.second1",match:t}),Object(g.jsx)(d.b,{className:"mb-5"})]})}),Object(g.jsx)(s.a,{children:Object(g.jsx)(d.a,{xxs:"12",className:"mb-4",children:Object(g.jsxs)("p",{children:[Object(g.jsxs)("h2",{children:[N,", ",A.odata.firstname]}),Object(g.jsx)(y,{data:A}),null!==C.datasets.data&&Object(g.jsx)(S,{data:C})]})})})]})}}}]);