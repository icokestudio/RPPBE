(this["webpackJsonpgogo-react"]=this["webpackJsonpgogo-react"]||[]).push([[13],{124:function(e,t,n){"use strict";var a=n(14),o=n(18),r=n(8),s=n.n(r),c=n(64),i=n.n(c),d=n(86),u=n.n(d),l=n(87),f={tag:l.o,inverse:i.a.bool,color:i.a.string,body:i.a.bool,outline:i.a.bool,className:i.a.string,cssModule:i.a.object,innerRef:i.a.oneOfType([i.a.object,i.a.string,i.a.func])},b=function(e){var t=e.className,n=e.cssModule,r=e.color,c=e.body,i=e.inverse,d=e.outline,f=e.tag,b=e.innerRef,m=Object(o.a)(e,["className","cssModule","color","body","inverse","outline","tag","innerRef"]),j=Object(l.k)(u()(t,"card",!!i&&"text-white",!!c&&"card-body",!!r&&(d?"border":"bg")+"-"+r),n);return s.a.createElement(f,Object(a.a)({},m,{className:j,ref:b}))};b.propTypes=f,b.defaultProps={tag:"div"},t.a=b},140:function(e,t,n){"use strict";var a=n(14),o=n(18),r=n(8),s=n.n(r),c=n(64),i=n.n(c),d=n(86),u=n.n(d),l=n(87),f=i.a.oneOfType([i.a.number,i.a.string]),b=i.a.oneOfType([i.a.bool,i.a.number,i.a.string,i.a.shape({size:i.a.oneOfType([i.a.bool,i.a.number,i.a.string]),order:f,offset:f})]),m={tag:l.o,xs:b,sm:b,md:b,lg:b,xl:b,className:i.a.string,cssModule:i.a.object,widths:i.a.array},j={tag:"div",widths:["xs","sm","md","lg","xl"]},p=function(e,t,n){return!0===n||""===n?e?"col":"col-"+t:"auto"===n?e?"col-auto":"col-"+t+"-auto":e?"col-"+n:"col-"+t+"-"+n},h=function(e){var t=e.className,n=e.cssModule,r=e.widths,c=e.tag,i=Object(o.a)(e,["className","cssModule","widths","tag"]),d=[];r.forEach((function(t,a){var o=e[t];if(delete i[t],o||""===o){var r=!a;if(Object(l.i)(o)){var s,c=r?"-":"-"+t+"-",f=p(r,t,o.size);d.push(Object(l.k)(u()(((s={})[f]=o.size||""===o.size,s["order"+c+o.order]=o.order||0===o.order,s["offset"+c+o.offset]=o.offset||0===o.offset,s)),n))}else{var b=p(r,t,o);d.push(b)}}})),d.length||d.push("col");var f=Object(l.k)(u()(t,d),n);return s.a.createElement(c,Object(a.a)({},i,{className:f}))};h.propTypes=m,h.defaultProps=j,t.a=h},141:function(e,t,n){"use strict";var a=n(14),o=n(18),r=n(8),s=n.n(r),c=n(64),i=n.n(c),d=n(86),u=n.n(d),l=n(87),f=i.a.oneOfType([i.a.number,i.a.string]),b={tag:l.o,noGutters:i.a.bool,className:i.a.string,cssModule:i.a.object,form:i.a.bool,xs:f,sm:f,md:f,lg:f,xl:f},m={tag:"div",widths:["xs","sm","md","lg","xl"]},j=function(e){var t=e.className,n=e.cssModule,r=e.noGutters,c=e.tag,i=e.form,d=e.widths,f=Object(o.a)(e,["className","cssModule","noGutters","tag","form","widths"]),b=[];d.forEach((function(t,n){var a=e[t];if(delete f[t],a){var o=!n;b.push(o?"row-cols-"+a:"row-cols-"+t+"-"+a)}}));var m=Object(l.k)(u()(t,r?"no-gutters":null,i?"form-row":"row",b),n);return s.a.createElement(c,Object(a.a)({},f,{className:m}))};j.propTypes=b,j.defaultProps=m,t.a=j},142:function(e,t,n){"use strict";var a=n(14),o=n(18),r=n(8),s=n.n(r),c=n(64),i=n.n(c),d=n(86),u=n.n(d),l=n(87),f={tag:l.o,className:i.a.string,cssModule:i.a.object},b=function(e){var t=e.className,n=e.cssModule,r=e.tag,c=Object(o.a)(e,["className","cssModule","tag"]),i=Object(l.k)(u()(t,"card-title"),n);return s.a.createElement(r,Object(a.a)({},c,{className:i}))};b.propTypes=f,b.defaultProps={tag:"div"},t.a=b},157:function(e,t,n){"use strict";var a=n(6),o=n(8),r=n(115),s=n(100);function c(e){var t=function(){var e=o.useContext(r.a);return Object(s.c)(e),e}(),n=t.formatMessage,a=t.textComponent,c=void 0===a?o.Fragment:a,i=e.id,d=e.description,u=e.defaultMessage,l=e.values,f=e.children,b=e.tagName,m=void 0===b?c:b,j=n({id:i,description:d,defaultMessage:u},l,{ignoreTag:e.ignoreTag});return Array.isArray(j)||(j=[j]),"function"===typeof f?f(j):m?o.createElement(m,null,o.Children.toArray(j)):o.createElement(o.Fragment,null,j)}c.displayName="FormattedMessage";var i=o.memo(c,(function(e,t){var n=e.values,o=Object(a.f)(e,["values"]),r=t.values,c=Object(a.f)(t,["values"]);return Object(s.d)(r,n)&&Object(s.d)(o,c)}));i.displayName="MemoizedFormattedMessage";t.a=i},365:function(e,t,n){"use strict";n.r(t);var a=n(8),o=n(141),r=n(124),s=n(142),c=n(93),i=n(94),d=n(95),u=n(11),l=n(24);t.default=function(){return Object(a.useEffect)((function(){return document.body.classList.add("background"),document.body.classList.add("no-footer"),function(){document.body.classList.remove("background"),document.body.classList.remove("no-footer")}}),[]),Object(l.jsxs)(l.Fragment,{children:[Object(l.jsx)("div",{className:"fixed-background"}),Object(l.jsx)("main",{children:Object(l.jsx)("div",{className:"container",children:Object(l.jsx)(o.a,{className:"h-100",children:Object(l.jsx)(i.a,{xxs:"12",md:"10",className:"mx-auto my-auto",children:Object(l.jsxs)(r.a,{className:"auth-card",children:[Object(l.jsxs)("div",{className:"position-relative image-side ",children:[Object(l.jsx)("p",{className:"text-white h2",children:"MAGIC IS IN THE DETAILS"}),Object(l.jsx)("p",{className:"white mb-0",children:"Yes, it is indeed!"})]}),Object(l.jsxs)("div",{className:"form-side",children:[Object(l.jsx)(c.b,{to:"/",className:"white"}),Object(l.jsx)(s.a,{className:"mb-4",children:Object(l.jsx)(d.a,{id:"pages.error-title"})}),Object(l.jsx)("p",{className:"mb-0 text-muted text-small mb-0",children:Object(l.jsx)(d.a,{id:"pages.error-code"})}),Object(l.jsx)("p",{className:"display-1 font-weight-bold mb-5",children:"404"}),Object(l.jsx)(c.b,{to:u.a,className:"btn btn-primary btn-shadow btn-lg",children:Object(l.jsx)(d.a,{id:"pages.go-back-home"})})]})]})})})})})]})}},366:function(e,t,n){"use strict";n.r(t);var a=n(8),o=n(141),r=n(124),s=n(142),c=n(93),i=n(94),d=n(95),u=n(11),l=n(24);t.default=function(){return Object(a.useEffect)((function(){return document.body.classList.add("background"),document.body.classList.add("no-footer"),function(){document.body.classList.remove("background"),document.body.classList.remove("no-footer")}}),[]),Object(l.jsxs)(l.Fragment,{children:[Object(l.jsx)("div",{className:"fixed-background"}),Object(l.jsx)("main",{children:Object(l.jsx)("div",{className:"container",children:Object(l.jsx)(o.a,{className:"h-100",children:Object(l.jsx)(i.a,{xxs:"12",md:"10",className:"mx-auto my-auto",children:Object(l.jsxs)(r.a,{className:"auth-card",children:[Object(l.jsxs)("div",{className:"position-relative image-side ",children:[Object(l.jsx)("p",{className:"text-white h2",children:"MAGIC IS IN THE DETAILS"}),Object(l.jsx)("p",{className:"white mb-0",children:"Yes, it is indeed!"})]}),Object(l.jsxs)("div",{className:"form-side",children:[Object(l.jsx)(c.b,{to:"/",className:"white"}),Object(l.jsx)(s.a,{className:"mb-4",children:Object(l.jsx)(d.a,{id:"unauthorized.title"})}),Object(l.jsx)("p",{className:"mb-0 text-muted text-small mb-0",children:Object(l.jsx)(d.a,{id:"unauthorized.detail"})}),Object(l.jsx)("p",{className:"display-1 font-weight-bold mb-5",children:"503"}),Object(l.jsx)(c.b,{to:u.a,className:"btn btn-primary btn-shadow btn-lg",children:Object(l.jsx)(d.a,{id:"pages.go-back-home"})})]})]})})})})})]})}},87:function(e,t,n){"use strict";n.d(t,"n",(function(){return s})),n.d(t,"g",(function(){return c})),n.d(t,"e",(function(){return i})),n.d(t,"k",(function(){return d})),n.d(t,"l",(function(){return u})),n.d(t,"m",(function(){return l})),n.d(t,"q",(function(){return b})),n.d(t,"p",(function(){return j})),n.d(t,"o",(function(){return p})),n.d(t,"c",(function(){return h})),n.d(t,"a",(function(){return g})),n.d(t,"b",(function(){return x})),n.d(t,"j",(function(){return O})),n.d(t,"d",(function(){return v})),n.d(t,"i",(function(){return N})),n.d(t,"h",(function(){return T})),n.d(t,"f",(function(){return M}));var a,o=n(64),r=n.n(o);function s(e){document.body.style.paddingRight=e>0?e+"px":null}function c(){var e=window.getComputedStyle(document.body,null);return parseInt(e&&e.getPropertyValue("padding-right")||0,10)}function i(){var e=function(){var e=document.createElement("div");e.style.position="absolute",e.style.top="-9999px",e.style.width="50px",e.style.height="50px",e.style.overflow="scroll",document.body.appendChild(e);var t=e.offsetWidth-e.clientWidth;return document.body.removeChild(e),t}(),t=document.querySelectorAll(".fixed-top, .fixed-bottom, .is-fixed, .sticky-top")[0],n=t?parseInt(t.style.paddingRight||0,10):0;document.body.clientWidth<window.innerWidth&&s(n+e)}function d(e,t){return void 0===e&&(e=""),void 0===t&&(t=a),t?e.split(" ").map((function(e){return t[e]||e})).join(" "):e}function u(e,t){var n={};return Object.keys(e).forEach((function(a){-1===t.indexOf(a)&&(n[a]=e[a])})),n}function l(e,t){for(var n,a=Array.isArray(t)?t:[t],o=a.length,r={};o>0;)r[n=a[o-=1]]=e[n];return r}var f={};function b(e){f[e]||("undefined"!==typeof console&&console.error(e),f[e]=!0)}var m="object"===typeof window&&window.Element||function(){};var j=r.a.oneOfType([r.a.string,r.a.func,function(e,t,n){if(!(e[t]instanceof m))return new Error("Invalid prop `"+t+"` supplied to `"+n+"`. Expected prop to be an instance of Element. Validation failed.")},r.a.shape({current:r.a.any})]),p=r.a.oneOfType([r.a.func,r.a.string,r.a.shape({$$typeof:r.a.symbol,render:r.a.func}),r.a.arrayOf(r.a.oneOfType([r.a.func,r.a.string,r.a.shape({$$typeof:r.a.symbol,render:r.a.func})]))]),h={Fade:150,Collapse:350,Modal:300,Carousel:600},g=["in","mountOnEnter","unmountOnExit","appear","enter","exit","timeout","onEnter","onEntering","onEntered","onExit","onExiting","onExited"],x={ENTERING:"entering",ENTERED:"entered",EXITING:"exiting",EXITED:"exited"},O={esc:27,space:32,enter:13,tab:9,up:38,down:40,home:36,end:35,n:78,p:80},v=!("undefined"===typeof window||!window.document||!window.document.createElement);function y(e){return null==e?void 0===e?"[object Undefined]":"[object Null]":Object.prototype.toString.call(e)}function N(e){var t=typeof e;return null!=e&&("object"===t||"function"===t)}function w(e){if(function(e){return!(!e||"object"!==typeof e)&&"current"in e}(e))return e.current;if(function(e){if(!N(e))return!1;var t=y(e);return"[object Function]"===t||"[object AsyncFunction]"===t||"[object GeneratorFunction]"===t||"[object Proxy]"===t}(e))return e();if("string"===typeof e&&v){var t=document.querySelectorAll(e);if(t.length||(t=document.querySelectorAll("#"+e)),!t.length)throw new Error("The target '"+e+"' could not be identified in the dom, tip: check spelling");return t}return e}function E(e){return null!==e&&(Array.isArray(e)||v&&"number"===typeof e.length)}function T(e,t){var n=w(e);return t?E(n)?n:null===n?[]:[n]:E(n)?n[0]:n}var M=["a[href]","area[href]","input:not([disabled]):not([type=hidden])","select:not([disabled])","textarea:not([disabled])","button:not([disabled])","object","embed","[tabindex]:not(.modal)","audio[controls]","video[controls]",'[contenteditable]:not([contenteditable="false"])']},94:function(e,t,n){"use strict";n.d(t,"a",(function(){return s})),n.d(t,"b",(function(){return c}));var a=n(1),o=(n(8),n(140)),r=n(24),s=function(e){return Object(r.jsx)(o.a,Object(a.a)(Object(a.a)({},e),{},{widths:["xxs","xs","sm","md","lg","xl","xxl"]}))},c=function(e){var t=e.className;return Object(r.jsx)("div",{className:"separator ".concat(t)})}},95:function(e,t,n){"use strict";var a=n(1),o=(n(8),n(157)),r=n(115),s=n(24);t.a=Object(r.c)((function(e){return Object(s.jsx)(o.a,Object(a.a)({},e))}),{withRef:!1})}}]);