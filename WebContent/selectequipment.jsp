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
        uniqueId: "uid",                     //每一行的唯一标识，一般为主键列
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
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            width: '15%',
        }, {
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
        }
        , {
            field: 'aaa',
            title: '编辑',
            align: 'center',
            width: '15%',
            formatter: function (value, row, index) {
            	return index+1;
            }
        }
        ],
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
	  onClickRow: function (row, $element) {
          currentrow = row;
          $("#mymodal").modal("show");
          
      }
    });

	//table数据跟新
   $('#mymodal').on('show.bs.modal', function () {
        $("#id_input").val(currentrow.id);
        $("#name_input").val(currentrow.name);
        $("#floorid_input").val(currentrow.floorid);
        $("#line_input").val(currentrow.line);
        $("#status_input").val(currentrow.status);
        
      });

	    
	$("#select").click(function(){
     var selectid=$("#select_id").val();
     var selectname=$("#select_name").val();
     var selectfloorid=$("#select_floorid").val();
     var selectline=$("#select_line").val();
     var begintime=$("#begintime").val();
     var endtime=$("#endtime").val();
		
       var parameters={
    		  id:selectid,
 	          name:selectname,
 	          floorid:selectfloorid,
 	          line:selectline,
 	          begintime:begintime,
 	          endtime:endtime,
    	       };
       var data={
                action:"selectequipment",
                msg:JSON.stringify(parameters),

    	       };
       var address='${pageContext.request.contextPath}/findEquipmentAll.do';
       var type='post';
       var jsondata=JSON.stringify(data);
       var callbackfunction = function (resdata) {
    	   if (resdata.result_signal != "ok") {
              alert(resdata.result);
    	   }else{
    		   /* alert(resdata.result); */
    		  $("#table_id").bootstrapTable('load',JSON.parse(resdata.result));
           }
    	   
         };
        useajax(address, type, jsondata, callbackfunction);
		});


	 $("#updateInfo").click(function(){
		  var input_id=$("#id_input").val();
		  if(input_id==null||input_id==""){
	             alert("设备编码不能为空");
	             return;
			  }
	      var input_name=$("#name_input").val();
	      if(input_name==null||input_name==""){
	           alert("设备名称不能为空");
	           return;
	          }
	      var input_floorid=$("#floorid_input").val();
	      if(input_floorid==null||input_floorid==""){
	          alert("楼层不能为空");
	          return;
	          }
	      var input_line=$("#line_input").val();
	      if(input_line==null||input_line==""){
	    	  alert("线体不能为空");
	          return;
	          }
	      var input_status=$("#status_input:checked").val();
	      if(input_status==null||input_status==""){
	    	  alert("状态不能为空");
	          return;
	          }
	      var input_remarks=$("#remarks_input").val();
	      if(input_remarks==null||input_remarks==""){
	    	  alert("备注不能为空");
	          return;
	          }
	      var parameters={
	          id:input_id,
	          name:input_name,
	          floorid:input_floorid,
	          line:input_line,
	          status:input_status,
	          remarks:input_remarks,
	    	      };
	     var data={
	    	     action:"updateEquipmentInfo",
	    	     msg:JSON.stringify(parameters),
	    	     };

	      var address='${pageContext.request.contextPath}/updateEquipmentInfo.do';
	      var type='post';
	      var jsondata = JSON.stringify(data);
	      var callbackfunction = function(resdata){
	           if(resdata.result_signal !="ok"){
	        	   alert(resdata.result);
	               }else{
	            	   alert(resdata.result);
	            	   $("#mymodal").modal("hide");
	                   }
	          };
	          useajax(address, type, jsondata, callbackfunction);
	  });

	  getLineInfo1();
	  function getLineInfo1(){
		  var line=null;
		     var data={
		    	     action:"findline",
		    	     msg:line
		    	     };
		  var address='${pageContext.request.contextPath}/findline.do';
	      var type='post';
	      var jsondata = JSON.stringify(data);
	      var callbackfunction = function(resdata){
	           if(resdata.result_signal !="ok"){
	        	   alert(resdata.result);
	               }else{
	            	   var selector=JSON.parse(resdata.result);
	                    for(var i=0;i<selector.length;i++){
	                        $("#line_input").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
	                        $("#select_line").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
	                    }
	                   }
	          };
	          useajax(address, type, jsondata, callbackfunction);
		  }
	  getFloorInfo1();
	  function getFloorInfo1(){
		  var floorid=null;
		     var data={
		    	     action:"findFloor",
		    	     msg:floorid
		    	     };
		  var address='${pageContext.request.contextPath}/findFloor.do';
	      var type='post';
	      var jsondata = JSON.stringify(data);
	      var callbackfunction = function(resdata){
	           if(resdata.result_signal !="ok"){
	        	   alert(resdata.result);
	               }else{
	            	   var selector=JSON.parse(resdata.result);
	                    for(var i=0;i<selector.length;i++){
	                        $("#select_floorid").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
	                        $("#floorid_input").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
	                    }
	                   }
	          };
	          useajax(address, type, jsondata, callbackfunction);
		  }

});

</script>

<body style="width: 100%; height: 100%;">
<div class="boy_layout boy_theme">
	    <table align="center" class="table_theme">
	       <tr>
	         <td>设备编码</td>
	         <td><input id="select_id" type="text" class="" ></td>
	         <td>设备名称</td>
	         <td><input id="select_name" type="text" class="" ></td>
	         <td>楼号</td>
	         <td><select id="select_floorid" type="text" class="" style="width: 150px" >
	           <option value="">----请选择楼号----</option>
	         </select></td>
	       </tr>
	    <tr>
	         <td>线体</td>
	         <td><select id="select_line" type="text" class="" style="width: 150px" overflow-y: scroll>
	             <option value="">----请选择线体----</option>
	         </select></td>
	         <td>开始时间</td>
	         <td><input id="begintime" type="text" class="" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" ></td>
	         <td>结束时间</td>
	         <td><input id="endtime" type="text" class=""  onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" ></td>
	       </tr>
	        <tr >
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	         <td align ="center" ><button id="select" class="" >查询</button></td>
	       </tr>
	    </table>
      <div id="contain" class="contain_layout contain_theme" style="height: 45rem;overflow-y: scroll">
         <table id="table_id" align="center" class="table_theme1">
	    </table>
	   </div> 
 <%--拟态框--%>
<div id="mymodal"
<%--调用拟态框类、淡入淡出效果--%>
     class="modal fade " tabindex="-1" role="dialog" style="margin-top: 20rem " 
     aria-labelledby="mymodallable" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" >
                <div class="contain">
                <div class="modal-font" > 移线</div>
                    <table align ="center">
                    <tr>
                     <td>设备编码</td>
                     <td><input id="id_input" type="text" class="" readonly="readonly"></td>
                    </tr>
                    <tr>
                     <td>设备名称</td>
                     <td><input id="name_input" type="text" class="" readonly="readonly"></td>
                    </tr>
                    <tr>
                     <td>楼层号</td>
                     <td><select id="floorid_input" type="text" class="" style="width: 150px" /></td>
                    </tr>
                    <tr>
                     <td>线体</td>
                     <td><select id="line_input" type="text" class="" style="width: 150px" /></td>
                    </tr>
                    <tr>
                     <td>状态</td>
                     <td><label><input id="status_input" name="1" type="radio" class="" checked="checked" value="在用"/>在用
                     <input id="status_input" name="1" type="radio" class="" value="空闲"/>空闲
                     <input id="status_input"  name="1" type="radio" class="" value="报废"/>报废</label></td>
                    </tr>
                    <tr>
                     <td>备注</td>
                     <td><textarea id="remarks_input"  class="" style="height: 6rem"></textarea></td>
                    </tr>
                    
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <a id="updateInfo" class="btn btn-primary">保存</a>
                <a class="btn btn-default" data-dismiss="modal">取消</a>
            </div>
        </div>
    </div>
    
	 </div>
</div>
</body>
</html>