<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
    <link rel="stylesheet" href="css/top.css">
    <script type="text/javascript">
    function time() {
    	//创建时间对象
        var date=new Date();
    	//创建星期数组
    	var week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六",);
    	//获取年
    	var y=date.getFullYear();
    	//获取月
    	var m=date.getMonth()+1;
    	//获取日
    	var d=date.getDate();
    	var h=date.getHours();//时
    	var min=date.getMinutes();//分
    	var s=date.getSeconds();//秒
    	if (h<10) {
			h="0"+h;
		}
    	if (min<10) {
			min="0"+min;
		}
    	if (s<10) {
			s="0"+s;
		}
    	//获取span标签
    	var sp=document.getElementById("sp");
    	sp.innerHTML=y+"-"+m+"-"+d+" "+week[date.getDay()]+" "+h+":"+min+":"+s;
	}
    window.setInterval(time,1000);
    </script>
</head>
<body onload="time">
    <div class="all">
        <div class="left">
            <img src="image/top-logo.gif" alt="">
        </div>
        <div class="right">
            <li>
                <span>${realname}</span>
                <span id="sp"></span>
                <span>感谢登录使用！</span>
            </li>
            <li class="bt-out">
                <a href="login.jsp" target="_parent">
                    <img src="image/out.gif" alt="">
                </a>
            </li>
        </div>
    </div>
</body>
</html>