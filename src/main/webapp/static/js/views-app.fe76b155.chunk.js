(this["webpackJsonpgogo-react"]=this["webpackJsonpgogo-react"]||[]).push([[12],{379:function(e,t,n){"use strict";n.r(t);var s=n(1),c=n(91),a=n(8),i=n.n(a),l=n(96),r=n(34),o=n(108),u=n(115),d=n(102),m=n(385),b=n(386),j=n(387),h=n(361),p=n(93),x=n(2),O=n(11),f=n(24),g=function(){return Object(f.jsxs)(f.Fragment,{children:[Object(f.jsxs)("svg",{className:"main",xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 9 17",children:[Object(f.jsx)("rect",{x:"0.48",y:"0.5",width:"7",height:"1"}),Object(f.jsx)("rect",{x:"0.48",y:"7.5",width:"7",height:"1"}),Object(f.jsx)("rect",{x:"0.48",y:"15.5",width:"7",height:"1"})]}),Object(f.jsxs)("svg",{className:"sub",xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 18 17",children:[Object(f.jsx)("rect",{x:"1.56",y:"0.5",width:"16",height:"1"}),Object(f.jsx)("rect",{x:"1.56",y:"7.5",width:"16",height:"1"}),Object(f.jsx)("rect",{x:"1.56",y:"15.5",width:"16",height:"1"})]})]})},v=function(){return Object(f.jsxs)("svg",{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 26 17",children:[Object(f.jsx)("rect",{x:"0.5",y:"0.5",width:"25",height:"1"}),Object(f.jsx)("rect",{x:"0.5",y:"7.5",width:"25",height:"1"}),Object(f.jsx)("rect",{x:"0.5",y:"15.5",width:"25",height:"1"})]})},w=n(95),C=(n(360),n(177)),k=n.n(C),S=Object(u.c)(Object(r.b)((function(e){var t=e.menu,n=e.settings;return{containerClassnames:t.containerClassnames,menuClickCount:t.menuClickCount,selectedMenuHasSubItems:t.selectedMenuHasSubItems,locale:n.locale}}),{setContainerClassnamesAction:x.kb,clickOnMobileMenuAction:x.gb,logoutUserAction:x.ib,changeLocaleAction:x.eb})((function(e){var t=e.intl,n=(e.history,e.containerClassnames),s=e.menuClickCount,i=e.selectedMenuHasSubItems,l=e.setContainerClassnamesAction,r=e.clickOnMobileMenuAction,u=(e.logoutUserAction,Object(a.useState)(!1)),x=Object(c.a)(u,2),w=x[0],C=x[1],k=Object(a.useState)(""),S=Object(c.a)(k,2),N=(S[0],S[1],Object(a.useContext)(o.context)),E=Object(c.a)(N,2),M=E[0];E[1],t.messages;return Object(f.jsxs)("nav",{className:"navbar fixed-top",children:[Object(f.jsxs)("div",{className:"d-flex align-items-center navbar-left",children:[Object(f.jsx)(p.b,{to:"#",location:{},className:"menu-button d-none d-md-block",onClick:function(e){return function(e,t,n){e.preventDefault(),setTimeout((function(){var e=document.createEvent("HTMLEvents");e.initEvent("resize",!1,!1),window.dispatchEvent(e)}),350),l(t+1,n,i)}(e,s,n)},children:Object(f.jsx)(g,{})}),Object(f.jsx)(p.b,{to:"#",location:{},className:"menu-button-mobile d-xs-block d-sm-block d-md-none",onClick:function(e){return function(e,t){e.preventDefault(),r(t)}(e,n)},children:Object(f.jsx)(v,{})})]}),Object(f.jsxs)(p.b,{className:"navbar-logo",to:O.a,children:[Object(f.jsx)("img",{src:"/assets/logos/black.svg",className:" logo d-none d-xs-block"}),Object(f.jsx)("img",{src:"/assets/logos/mobile.svg",className:"logo-mobile d-block d-xs-none"})]}),Object(f.jsxs)("div",{className:"navbar-right",children:[Object(f.jsx)("div",{className:"header-icons d-inline-block align-middle",children:Object(f.jsx)("button",{className:"header-icon btn btn-empty d-none d-sm-inline-block",type:"button",id:"fullScreenButton",onClick:function(){var e=document.fullscreenElement&&null!==document.fullscreenElement||document.webkitFullscreenElement&&null!==document.webkitFullscreenElement||document.mozFullScreenElement&&null!==document.mozFullScreenElement||document.msFullscreenElement&&null!==document.msFullscreenElement,t=document.documentElement;e?document.exitFullscreen?document.exitFullscreen():document.webkitExitFullscreen?document.webkitExitFullscreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.msExitFullscreen&&document.msExitFullscreen():t.requestFullscreen?t.requestFullscreen():t.mozRequestFullScreen?t.mozRequestFullScreen():t.webkitRequestFullScreen?t.webkitRequestFullScreen():t.msRequestFullscreen&&t.msRequestFullscreen(),C(!e)},children:w?Object(f.jsx)("i",{className:"simple-icon-size-actual d-block"}):Object(f.jsx)("i",{className:"simple-icon-size-fullscreen d-block"})})}),Object(f.jsx)("div",{className:"user d-inline-block",children:Object(f.jsxs)(m.a,{className:"dropdown-menu-right",children:[Object(f.jsxs)(b.a,{className:"p-0",color:"empty",children:[Object(f.jsx)("span",{className:"name mr-1",children:"".concat(M.odata.firstname," ").concat(M.odata.lastname)}),Object(f.jsx)("span",{children:Object(f.jsx)("img",{alt:"Profile",src:"/assets/img/profiles/l-1.jpg"})})]}),Object(f.jsxs)(j.a,{className:"mt-3",right:!0,children:[Object(f.jsx)(h.a,{children:"Account"}),Object(f.jsx)(h.a,{divider:!0}),Object(f.jsx)(h.a,{onClick:function(){return sessionStorage.clear(),location.replace("/user/login"),void d.b.warning("Logout successful","Success",2500,null,null,"")},children:"Sign out"})]})]})})]})]})}))),N=n(113),E=n(114),M=n(161),y=n(122),L=n(120),F=n(26),P=n.n(F),H=n(362),z=n(363),I=n(364),R=n(86),q=n.n(R),A=[{id:"gogo",icon:"iconsminds-air-balloon-1",label:"menu.gogo",to:"".concat(O.a,"/admin"),subs:[{icon:"simple-icon-paper-plane",label:"menu.start",to:"".concat(O.a,"/admin/dashboard")},{icon:"simple-icon-paper-plane",label:"menu.start2",to:"".concat(O.a,"/admin/results")}]},{id:"Student",icon:"iconsminds-three-arrow-fork",label:"menu.second-menu",to:"".concat(O.a,"/student"),subs:[{icon:"simple-icon-paper-plane",label:"menu.second1",to:"".concat(O.a,"/student/dashboard")},{icon:"simple-icon-paper-plane",label:"menu.second2",to:"".concat(O.a,"/student/result")}]},{id:"blankpage",icon:"iconsminds-bucket",label:"menu.blank-page",to:"".concat(O.a,"/operator"),subs:[{icon:"simple-icon-paper-plane",label:"menu.second3",to:"".concat(O.a,"/operator/dashboard")}]}],_=function(e){Object(y.a)(n,e);var t=Object(L.a)(n);function n(e){var s;return Object(N.a)(this,n),(s=t.call(this,e)).handleWindowResize=function(e){if(!e||e.isTrusted){var t=s.props.containerClassnames,n=s.getMenuClassesForResize(t);s.props.setContainerClassnames(0,n.join(" "),s.props.selectedMenuHasSubItems)}},s.handleDocumentClick=function(e){var t=s.getContainer(),n=!1;(e.target&&e.target.classList&&(e.target.classList.contains("menu-button")||e.target.classList.contains("menu-button-mobile"))||e.target.parentElement&&e.target.parentElement.classList&&(e.target.parentElement.classList.contains("menu-button")||e.target.parentElement.classList.contains("menu-button-mobile"))||e.target.parentElement&&e.target.parentElement.parentElement&&e.target.parentElement.parentElement.classList&&(e.target.parentElement.parentElement.classList.contains("menu-button")||e.target.parentElement.parentElement.classList.contains("menu-button-mobile")))&&(n=!0),t.contains(e.target)||t===e.target||n||(s.setState({viewingParentMenu:""}),s.toggle())},s.getMenuClassesForResize=function(e){var t=s.props,n=t.menuHiddenBreakpoint,c=t.subHiddenBreakpoint,a=e.split(" ").filter((function(e){return""!==e})),i=window.innerWidth;return i<n?a.push("menu-mobile"):i<c?(a=a.filter((function(e){return"menu-mobile"!==e}))).includes("menu-default")&&!a.includes("menu-sub-hidden")&&a.push("menu-sub-hidden"):(a=a.filter((function(e){return"menu-mobile"!==e}))).includes("menu-default")&&a.includes("menu-sub-hidden")&&(a=a.filter((function(e){return"menu-sub-hidden"!==e}))),a},s.getContainer=function(){return P.a.findDOMNode(Object(M.a)(s))},s.toggle=function(){var e=s.getIsHasSubItem();s.props.changeSelectedMenuHasSubItems(e);var t=s.props,n=t.containerClassnames,c=t.menuClickCount,a=n?n.split(" ").filter((function(e){return""!==e})):"",i=-1;e?a.includes("menu-sub-hidden")&&3===c?i=2:(a.includes("menu-hidden")||a.includes("menu-mobile"))&&(i=0):!a.includes("menu-default")||c%4!==0&&c%4!==3?!a.includes("menu-sub-hidden")||2!==c&&3!==c?(a.includes("menu-hidden")||a.includes("menu-mobile"))&&(i=0):i=0:i=1,i>=0&&s.props.setContainerClassnames(i,n,e)},s.handleProps=function(){s.addEvents()},s.addEvents=function(){["click","touchstart","touchend"].forEach((function(e){return document.addEventListener(e,s.handleDocumentClick,!0)}))},s.removeEvents=function(){["click","touchstart","touchend"].forEach((function(e){return document.removeEventListener(e,s.handleDocumentClick,!0)}))},s.setSelectedLiActive=function(e){var t=document.querySelector(".sub-menu  li.active");null!=t&&t.classList.remove("active");var n=document.querySelector(".third-level-menu  li.active");null!=n&&n.classList.remove("active");var c=document.querySelector(".third-level-menu  a.active");null!=c&&c.parentElement.classList.add("active");var a=document.querySelector(".sub-menu  a.active");if(null!=a)a.parentElement.classList.add("active"),s.setState({selectedParentMenu:a.parentElement.parentElement.getAttribute("data-parent")},e);else{var i=document.querySelector(".main-menu  li a.active");null!=i?s.setState({selectedParentMenu:i.getAttribute("data-flag")},e):""===s.state.selectedParentMenu&&s.setState({selectedParentMenu:A[0].id},e)}},s.setHasSubItemStatus=function(){var e=s.getIsHasSubItem();s.props.changeSelectedMenuHasSubItems(e),s.toggle()},s.getIsHasSubItem=function(){var e=s.state.selectedParentMenu,t=A.find((function(t){return t.id===e}));return!!t&&!!(t&&t.subs&&t.subs.length>0)},s.openSubMenu=function(e,t){var n=t.id,c=t.subs&&t.subs.length>0;if(s.props.changeSelectedMenuHasSubItems(c),c){e.preventDefault();var a=s.props,i=a.containerClassnames,l=a.menuClickCount,r=i?i.split(" ").filter((function(e){return""!==e})):"";r.includes("menu-mobile")?s.props.addContainerClassname("sub-show-temporary",i):!r.includes("menu-sub-hidden")||2!==l&&0!==l?!r.includes("menu-hidden")||1!==l&&3!==l?!r.includes("menu-default")||r.includes("menu-sub-hidden")||1!==l&&3!==l||s.props.setContainerClassnames(0,i,c):s.props.setContainerClassnames(2,i,c):s.props.setContainerClassnames(3,i,c),s.setState({viewingParentMenu:n})}else s.setState({viewingParentMenu:n,selectedParentMenu:n}),s.toggle()},s.toggleMenuCollapse=function(e,t){e.preventDefault();var n=s.state.collapsedMenus;return n.indexOf(t)>-1?s.setState({collapsedMenus:n.filter((function(e){return e!==t}))}):(n.push(t),s.setState({collapsedMenus:n})),!1},s.filteredList=function(e){return void 0===e[0].id?e:"admin"===s.context[0].role?[e[0]]:"student"===s.context[0].role?[e[1]]:"course_operator"===s.context[0].role?[e[2]]:void 0},s.state={selectedParentMenu:"",viewingParentMenu:"",collapsedMenus:[]},s}return Object(E.a)(n,[{key:"componentDidUpdate",value:function(e){this.props.location.pathname!==e.location.pathname&&(this.setSelectedLiActive(this.setHasSubItemStatus),window.scrollTo(0,0)),this.handleProps()}},{key:"componentDidMount",value:function(){window.addEventListener("resize",this.handleWindowResize),this.handleWindowResize(),this.handleProps(),this.setSelectedLiActive(this.setHasSubItemStatus)}},{key:"componentWillUnmount",value:function(){this.removeEvents(),window.removeEventListener("resize",this.handleWindowResize)}},{key:"render",value:function(){var e=this,t=this.state,n=t.selectedParentMenu,s=t.viewingParentMenu,c=t.collapsedMenus;return Object(f.jsxs)("div",{className:"sidebar",children:[Object(f.jsx)("div",{className:"main-menu",children:Object(f.jsx)("div",{className:"scroll",children:Object(f.jsx)(k.a,{options:{suppressScrollX:!0,wheelPropagation:!1},children:Object(f.jsx)(H.a,{vertical:!0,className:"list-unstyled",children:A&&this.filteredList(A).map((function(t){return Object(f.jsx)(z.a,{className:q()({active:n===t.id&&""===s||s===t.id}),children:t.newWindow?Object(f.jsxs)("a",{href:t.to,rel:"noopener noreferrer",target:"_blank",children:[Object(f.jsx)("i",{className:t.icon})," ",Object(f.jsx)(w.a,{id:t.label})]}):Object(f.jsxs)(p.b,{to:t.to,onClick:function(n){return e.openSubMenu(n,t)},"data-flag":t.id,children:[Object(f.jsx)("i",{className:t.icon})," ",Object(f.jsx)(w.a,{id:t.label})]})},t.id)}))})})})}),Object(f.jsx)("div",{className:"sub-menu",children:Object(f.jsx)("div",{className:"scroll",children:Object(f.jsx)(k.a,{options:{suppressScrollX:!0,wheelPropagation:!1},children:A&&this.filteredList(A).map((function(t){return Object(f.jsx)(H.a,{className:q()({"d-block":e.state.selectedParentMenu===t.id&&""===e.state.viewingParentMenu||e.state.viewingParentMenu===t.id}),"data-parent":t.id,children:t.subs&&e.filteredList(t.subs).map((function(n,s){return Object(f.jsx)(z.a,{className:"".concat(n.subs&&n.subs.length>0?"has-sub-item":""),children:n.newWindow?Object(f.jsxs)("a",{href:n.to,rel:"noopener noreferrer",target:"_blank",children:[Object(f.jsx)("i",{className:n.icon})," ",Object(f.jsx)(w.a,{id:n.label})]}):n.subs&&n.subs.length>0?Object(f.jsxs)(f.Fragment,{children:[Object(f.jsxs)(p.b,{className:"rotate-arrow-icon opacity-50 ".concat(-1===c.indexOf("".concat(t.id,"_").concat(s))?"":"collapsed"),to:n.to,id:"".concat(t.id,"_").concat(s),onClick:function(n){return e.toggleMenuCollapse(n,"".concat(t.id,"_").concat(s))},children:[Object(f.jsx)("i",{className:"simple-icon-arrow-down"})," ",Object(f.jsx)(w.a,{id:n.label})]}),Object(f.jsx)(I.a,{isOpen:-1===c.indexOf("".concat(t.id,"_").concat(s)),children:Object(f.jsx)(H.a,{className:"third-level-menu",children:e.filteredList(n.subs).map((function(e,n){return Object(f.jsx)(z.a,{children:e.newWindow?Object(f.jsxs)("a",{href:e.to,rel:"noopener noreferrer",target:"_blank",children:[Object(f.jsx)("i",{className:e.icon})," ",Object(f.jsx)(w.a,{id:e.label})]}):Object(f.jsxs)(p.b,{to:e.to,children:[Object(f.jsx)("i",{className:e.icon})," ",Object(f.jsx)(w.a,{id:e.label})]})},"".concat(t.id,"_").concat(s,"_").concat(n))}))})})]}):Object(f.jsxs)(p.b,{to:n.to,children:[Object(f.jsx)("i",{className:n.icon})," ",Object(f.jsx)(w.a,{id:n.label})]})},"".concat(t.id,"_").concat(s))}))},t.id)}))})})})]})}}]),n}(a.Component);_.contextType=o.context;var D=Object(l.g)(Object(r.b)((function(e){var t=e.menu,n=e.authUser;return{containerClassnames:t.containerClassnames,subHiddenBreakpoint:t.subHiddenBreakpoint,menuHiddenBreakpoint:t.menuHiddenBreakpoint,menuClickCount:t.menuClickCount,selectedMenuHasSubItems:t.selectedMenuHasSubItems,currentUser:n.currentUser}}),{setContainerClassnames:x.kb,addContainerClassname:x.cb,changeDefaultClassnames:x.db,changeSelectedMenuHasSubItems:x.fb})(_)),B=n(141),W=n(94),U=function(){return Object(f.jsx)("footer",{className:"page-footer",children:Object(f.jsx)("div",{className:"footer-content",children:Object(f.jsx)("div",{className:"container-fluid",children:Object(f.jsxs)(B.a,{children:[Object(f.jsx)(W.a,{xxs:"12",sm:"6",children:Object(f.jsx)("p",{className:"mb-0 text-muted",children:"Result Processing Platform"})}),Object(f.jsx)(W.a,{className:"col-sm-6 d-none d-sm-block",children:Object(f.jsxs)("ul",{className:"breadcrumb pt-0 pr-0 float-right",children:[Object(f.jsx)("li",{className:"breadcrumb-item mb-0",children:Object(f.jsx)(p.b,{className:"btn-link",to:"#",location:{},children:"Simple"})}),Object(f.jsx)("li",{className:"breadcrumb-item mb-0",children:Object(f.jsx)(p.b,{className:"btn-link",to:"#",location:{},children:"Fast"})}),Object(f.jsx)("li",{className:"breadcrumb-item mb-0",children:Object(f.jsx)(p.b,{className:"btn-link",to:"#",location:{},children:"Effective"})})]})})]})})})})},T=Object(l.g)(Object(r.b)((function(e){return{containerClassnames:e.menu.containerClassnames}}),{})((function(e){var t=e.containerClassnames,n=e.children,s=e.history;return Object(f.jsxs)("div",{id:"app-container",className:t,children:[Object(f.jsx)(S,{history:s}),Object(f.jsx)(D,{}),Object(f.jsx)("main",{children:Object(f.jsx)("div",{className:"container-fluid",children:n})}),Object(f.jsx)(U,{})]})}))),J=i.a.lazy((function(){return n.e(16).then(n.bind(null,367))})),X=i.a.lazy((function(){return n.e(17).then(n.bind(null,368))})),G=i.a.lazy((function(){return Promise.all([n.e(0),n.e(2),n.e(15)]).then(n.bind(null,369))}));t.default=Object(l.g)(Object(r.b)((function(e){return{containerClassnames:e.menu.containerClassnames}}),{})((function(e){var t=e.match,n=Object(a.useContext)(o.context),i=Object(c.a)(n,2),r=i[0];i[1];return Object(f.jsxs)(T,{children:[Object(f.jsxs)("div",{className:"dashboard-wrapper",children:[Object(f.jsxs)(a.Suspense,{fallback:Object(f.jsx)("div",{className:"loading"}),children:[Object(f.jsxs)(l.d,{children:[" ","admin"===r.role&&Object(f.jsx)(l.a,{exact:!0,from:"".concat(t.url,"/"),to:"".concat(t.url,"/admin")})," ","student"===r.role&&Object(f.jsx)(l.a,{exact:!0,from:"".concat(t.url,"/"),to:"".concat(t.url,"/student")})," ","course_operator"===r.role&&Object(f.jsx)(l.a,{exact:!0,from:"".concat(t.url,"/"),to:"".concat(t.url,"/operator")})," ","admin"===r.role&&Object(f.jsx)(l.b,{path:"".concat(t.url,"/admin"),render:function(e){return Object(f.jsx)(J,Object(s.a)({},e))}})," ","student"===r.role&&Object(f.jsx)(l.b,{path:"".concat(t.url,"/student"),render:function(e){return Object(f.jsx)(X,Object(s.a)({},e))}})," ","course_operator"===r.role&&Object(f.jsx)(l.b,{path:"".concat(t.url,"/operator"),render:function(e){return Object(f.jsx)(G,Object(s.a)({},e))}})," ",Object(f.jsx)(l.a,{to:"/error"})]})," "]})," "]})," "]})})))},94:function(e,t,n){"use strict";n.d(t,"a",(function(){return i})),n.d(t,"b",(function(){return l}));var s=n(1),c=(n(8),n(140)),a=n(24),i=function(e){return Object(a.jsx)(c.a,Object(s.a)(Object(s.a)({},e),{},{widths:["xxs","xs","sm","md","lg","xl","xxl"]}))},l=function(e){var t=e.className;return Object(a.jsx)("div",{className:"separator ".concat(t)})}},95:function(e,t,n){"use strict";var s=n(1),c=(n(8),n(157)),a=n(115),i=n(24);t.a=Object(a.c)((function(e){return Object(i.jsx)(c.a,Object(s.a)({},e))}),{withRef:!1})}}]);