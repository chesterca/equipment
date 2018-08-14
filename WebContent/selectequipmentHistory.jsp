<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/font.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/themes.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajaxFunction.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/js/bootstrap-3.3.7-dist/css/bootstrap.css">

    <script src="${pageContext.request.contextPath}/js/bootstrap-table-dist/bootstrap-table.js"></script>
    <script
            src="${pageContext.request.contextPath}/js/bootstrap-table-dist/locale/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/js/bootstrap-table-dist/bootstrap-table.css">

    <link href="${pageContext.request.contextPath}/js/bootstrap-x-editable-dist/bootstrap3-editable/css/bootstrap-editable.css"/>

    <script src="${pageContext.request.contextPath}/js/bootstrap-x-editable-dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcore.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcalendar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
   



<title>TE设备系统</title>
<style>
body {
	margin: 0;
	padding: 0;
}
.table_theme{
background-color:#f77000;
width: 60%; 
height: 20%;

}

.table_theme1{
background-color:#00FFFF;
width: 80%; 
}

.boy_layout{
   align: center;
   margin: 0;
   padding: 0;
}


</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
	 var fsize = parseFloat(getComputedStyle(window.document.documentElement)['font-size']);
	 var currentrow;
	  $("#table_id").bootstrapTable({
        smartDisplay: true,
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页
        pageSize: 6,                        //每页的记录行数（*）
        pageList: [6, 12, 16, 20],          //可供选择的每页的行数（*）
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        pagination: true,                   //显示分页条
        showPaginationSwitch: true,         //显示分页条开关
        showHeader: true,                    //显示标题
        columns: [{
            field: 'id',
            title: '设备编码',
            align: 'center',
            width: '5%',
           /*  formatter: function (value, row, index) {
                return index + 1;
            } */
        }, {
            field: 'name',
            title: '设备名称',
            align: 'center',
            width: '15%',
        },  {
            field: 'line',
            title: '线体',
            align: 'center',
            width: '15%',
        }, {
            field: 'floorid',
            title: '楼层',
            align: 'center',
            width: '15%',
        }, {
            field: 'remarks',
            title: '备注',
            align: 'center',
            width: '15%',
        }, {
            field: 'time',
            title: '时间',
            align: 'center',
            width: '15%',
        }
        , {
            field: 'userid',
            title: '用户名',
            align: 'center',
            width: '15%',
        }],
        height: (fsize * 40),
        rowStyle: function (row, index) {
            var style = {
                css: {
                    'background-color': '#00FFFF',
                    'font-family': '黑体',
                    'height': '4rem'
                }
            };
            return style;
        },
    });
	 /*  $("#table_theme").bootstrapTable({
		  height: (fsize * 40),
	        rowStyle: function (row, index) {
	            var style = {
	                css: {
	                    'background-color': '#00FFFF',
	                    'font-family': '黑体',
	                    'height': '4rem'
	                }
	            };
	            return style;
	        },
	    }); */
	    
	$("#selecthitory").click(function(){
	   var id=$("#history_id").val();
	   var begintime=$("#history_begintime").val();
	   var endtime=$("#hitsory_endtime").val();
       var parameters={
    		  id:id,
    		  begintime:begintime,
    		  endtime:endtime
    	       };
       var data={
                action:"selectequipmenHistory",
                msg:JSON.stringify(parameters)

    	       };
       var address='${pageContext.request.contextPath}/findEquipmentHistory.do';
       var type='post';
       var jsondata=JSON.stringify(data);
       var callbackfunction = function (resdata) {
    	   if (resdata.result_signal != "ok") {
              alert(resdata.result);
    	   }else{
    		  /*  alert(resdata.result); */
    		  $("#table_id").bootstrapTable('load',JSON.parse(resdata.result));
           }
    	   
         };
        useajax(address, type, jsondata, callbackfunction);
		});
	
});
</script>

<body style="width: 100%; height: 100%;">
<div class="boy_layout boy_theme">
	    <table id="table_theme" align="center" class="table_theme">
	       <tr>
	         <td>设备编码</td>
	         <td><input id="history_id" type="text" class="" ></td>
	         <td>开始时间</td>
	         <td><input id="history_begintime" type="text" class="" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
	         <td>结束时间</td>
	         <td><input id="hitsory_endtime" type="text" class="" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
	       </tr>
	        <tr >
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	         <td align ="center" ><button id="selecthitory" class="" >查询</button></td>
	       </tr>
	    </table>
      <div id="contain" class="contain_layout contain_theme" style="height: 45rem;overflow-y: scroll">
         <table id="table_id" align="center" class="table_theme1">
	    </table>
	   </div> 
</div>
</body>
</html>