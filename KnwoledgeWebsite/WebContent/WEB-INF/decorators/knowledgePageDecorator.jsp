<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><dec:title default="Web Page" /></title>
        <style type="text/css" media="print"> 
			@media print { 
			body { display:none } 
			} 

		</style> 
        <link rel="stylesheet" type="text/css" href="../css/test-style.css" />
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <dec:head />
        <script>
        var blinkTimer;
		function onHide(){
  			$("#topBar").animate( {"opacity": 0},
  					           		 "slow"); 
  			blinkTimer=window.setTimeout("onShow()", 1000);
 				
		}
		function onShow(){
  			$("#topBar").animate( {"opacity": 1},
  					           		 "slow"); 
  			blinkTimer=window.setTimeout("onHide()", 3000);
 				
		}
		var MAX=51;
	    window.setTimeout("showAd11()", 1000*60);	
		window.setTimeout("showAd21()", 1000*60);
	    window.setTimeout("showAd31()", 1000*60);
	    window.setTimeout("showAd41()", 1000*60);
	    window.setTimeout("showAd51()", 1000*60);
	    window.setTimeout("showAd12()", 1000*60);
	    window.setTimeout("showAd22()", 1000*60);
	    window.setTimeout("showAd32()", 1000*60);
	    window.setTimeout("showAd42()", 1000*60);
	    window.setTimeout("showAd52()", 1000*60);
	    function showAd11(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
	     	document.getElementById('ad11').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
	     	window.setTimeout("showAd11()", 1000*60);
	     }
	    function showAd21(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
       		document.getElementById('ad21').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd21()", 1000*60);
        }
	    function showAd31(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
      		document.getElementById('ad31').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd31()", 1000*60);
     	}
	    function showAd41(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
      		document.getElementById('ad41').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd41()", 1000*60);
    	}
	    function showAd51(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
     		document.getElementById('ad51').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd51()", 1000*60);
     	}
	    function showAd12(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
      		document.getElementById('ad12').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd12()", 1000*60);
     	}
	    function showAd22(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
      		document.getElementById('ad22').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd22()", 1000*60);
     	}
	    function showAd32(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
     		document.getElementById('ad32').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd32()", 1000*60);
     	}
	    function showAd42(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
       		document.getElementById('ad42').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd42()", 1000*60);
     	}
	    function showAd52(){
	    	var num=Math.floor(Math.random()*MAX);
	    	num=num+1;
      		document.getElementById('ad52').innerHTML = "<img src=../image/ads/blog"+num+".jpg  width=160 height=185 alt=Test Java Skills/>";
     		window.setTimeout("showAd52()", 1000*60);
     	}
     	</script>
        <script type="text/javascript">
        	var timeLeft;
     		var timer;
        	function setTitleBar(time){
        		timeLeft = time;
        		if(document.URL.search('testQuestionView') != -1 || document.URL.search('compJavaTestView') != -1 || document.URL.search('cppTestView') != -1 || document.URL.search('javaTestView') != -1 || document.URL.search('designTestView') != -1) {
	        		document.getElementById('titleBar').innerHTML = "Time Left(seconds): "+timeLeft;
	        	    timer=window.setTimeout("tick()", 1000);
	        	    onHide();
        		}else{
        			if(document.URL.search('testRegistrationView') != -1) {
        				document.getElementById('titleBar').innerHTML = "REGISTRATION!!!!";
        				onHide();
        			}
					if(document.URL.search('testAgreementView') != -1) {
						document.getElementById('titleBar').innerHTML = "TERMS AND CONDITIONS"; 
						onHide();
        			}
					if(document.URL.search('knowledgeView') != -1) {
						onHide();
						document.getElementById('titleBar').innerHTML = "Enjoy & Have a Nice Day:-)"; 
        			}
					if(document.URL.search('testResultView') != -1) {
						onHide();
						document.getElementById('titleBar').innerHTML = "<a href='/knowledge/knowledgeView.html'><font color='#000000'>Go Back</font></a>"; 
        			}
					if(document.URL.search('testResultDetailView') != -1) {
						onHide();
						document.getElementById('titleBar').innerHTML = "<a href='/knowledge/testResultView.html'><font color='#000000'>Go Back</font></a>";
					}
          		}
        	}
        	function tick() {
        		timeLeft -= 1;
        		if(document.URL.search('testQuestionView') != -1 || document.URL.search('compJavaTestView') != -1 || document.URL.search('cppTestView') != -1 || document.URL.search('javaTestView') != -1 || document.URL.search('designTestView') != -1) {
        			document.getElementById('titleBar').innerHTML = "Time Left(seconds): "+timeLeft;
	        	    if(timeLeft == 0){
	        	    	alert("Timeout occured...please press OK to go to next question");
	        	    	 document.questionForm.submit.click();
	        	    	
	        	    }else{
	        	    	timer=window.setTimeout("tick()", 1000);
	        	    }
        		}
        	}
        	//below javascript is used for Disabling right-click on HTML page
        	document.oncontextmenu=new Function("return false");//Disabling right-click
        	//below javascript is used for Disabling text selection in web page
        	document.onselectstart=new Function ("return false"); //Disabling text selection in web page
        	if (window.sidebar){
        	document.onmousedown=new Function("return false"); 
	        	document.onclick=new Function("return true") ; 
	        	//Disable Cut into HTML form using Javascript 
	        	document.oncut=new Function("return false"); 
	        	//Disable Copy into HTML form using Javascript 
	        	document.oncopy=new Function("return false"); 
	        	//Disable Paste into HTML form using Javascript  
	        	document.onpaste=new Function("return false"); 
        	}
     </script>
    </head>
    <body onload="setTitleBar(150);">
        <div id="bodyWrapper">
        	<div id="topBar">"It's FREE....Call  +353894647147 or write to tbsingh@gmail.com for any issues or questions."
        	</div>
            <div id="topBar">
	        		<a href="http://www.myspace.com/ "target="_blank"><img src="http://www.niftybuttons.com/komodomedia/myspace_16.png" border="0" title="MySpace"></a>
					<a href="http://www.youtube.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/youtube_16.png" border="0" title="Youtube"></a>
					<a href="https://twitter.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/twitter_16.png" border="0" title="Twitter"></a>
					<a href="http://www.facebook.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/facebook_16.png" border="0" title="Facebook"></a>
					<a href="www.blogger.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/blogger_16.png" border="0" title="Blogger"></a>
					<a href="http://www.flickr.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/flickr_16.png" border="0" title="Flicker"></a>
					<a href="http://www.stumbleupon.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/stumbleupon_16.png" border="0" title="Stumble Upon"></a>
					<a href="http://friendfeed.com/" target="_blank"><img src="http://www.niftybuttons.com/komodomedia/friendfeed_16.png" border="0" title="Friend Feed"></a>
	       	</div>
            <div id="header">
               <div id="headerTop">
               <table width="100%" ><tr>
	          	<c:forEach begin="1" end="40" step="1">
  						<td width="2.5%"><img src="<c:url value="../image/om.gif"/>" width="12px" height="12px" alt="OM"/></td>
				</c:forEach>
		       	</tr>
           	   </table>
               </div>
                <div id="headerLeft">
               	<img src="../image/maa-saraswati.jpg"  width="170" height="120" alt="MAA Saraswati"/>
               </div>
            	 <!-- <div id="headerRight">
               	<img src="../image/maa-saraswati.jpg"  width="160" height="120" alt="MAA Saraswati"/>
               	</div>-->
            	 <div id="headerCentre">
               		<table width="74%">
               			<tr><td><p style="font-size:large; color:#0000FF"><c:out value="${command.pageTitle}"/></p></td></tr>
               		</table>
               </div>
         	</div>
         <div id="titleBar">
         </div>
         <div id="pageBody">
             <div id="sidebarLeft">
             	<div id="ad11"><img src="../image/ads/blog1.jpg"  width="160" height="185" alt="Test Hibernate Skills"/></div> 
                <div id="ad21"><img src="../image/ads/blog2.jpg"  width="160" height="185" alt="Test C++ Skills"/></div> 
	            <div id="ad31"><img src="../image/ads/blog3.jpg"  width="160" height="185" alt="Test Spring Skills"/></div>
	            <div id="ad41"><img src="../image/ads/blog4.jpg"  width="160" height="185" alt="Test Java Skills"/></div>
	            <div id="ad51"><img src="../image/ads/blog5.jpg"  width="160" height="185" alt="Test Java Skills"/></div>
             </div>
             <div id="sidebarLeftInner">
             </div>
           <!--   <div id="sidebarRight">
               	  <div id="ad12"><img src="../image/ads/blog6.jpg"  width="160" height="185" alt="Test Java Skills"/></div>
	              <div id="ad22"><img src="../image/ads/blog7.jpg"  width="160" height="185" alt="Test JSP Skills"/></div>
	              <div id="ad32"><img src="../image/ads/blog8.jpg"  width="160" height="185" alt="Test Design Pattern Skills"/></div>
	              <div id="ad42"><img src="../image/ads/blog9.jpg"  width="160" height="185" alt="Test Hibernate Skills"/></div>
              	  <div id="ad52"><img src="../image/ads/blog10.jpg"  width="160" height="185" alt="Test Java Skills"/></div>
              </div>
              <div id="sidebarRightInner">
              </div>--> 
              
             <div id="mainContent">
               	<dec:body />
             </div>
            </div>
            <div id="footer">
               Copyright 2012, TSSA SOFTWARE GROUP, INDIA - All Rights Reserved.
            </div>
        </div>
    </body>
</html>
