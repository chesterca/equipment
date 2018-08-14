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
    <script  src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    
<title>TE设备系统</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.top_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/thime2.jpg")
		no-repeat;
	background-size: 100% 75px;
	overflow: hidden;
}

.floor_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/thime2.jpg")
		no-repeat;
	background-size: 100% 75px;
	overflow: hidden;
	text-align: center;
}
.boy_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/1.jpg")
		no-repeat;  
	background-size: 100% 660px;
	overflow: hidden;
	text-align: center;
}

.contain_layout{
 width:100%;
 height:614px;

}
.contain_theme{
text-align:center;
}


.boy_layout{
 width:100%;
 height:660px;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background: url("${pageContext.request.contextPath}/thime2.jpg")
		no-repeat; 
    /* background-color: #000000; */
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #EE7700;
}
</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
	/* 查询信息 */
  $("#selectequipment").click(function(){
      var pageid = "selectequipment";
      if(pageid!=null){
          $("#contain").load("${pageContext.request.contextPath}/"+pageid+".do");
      }
  }); 

	/* 详细查询 */
  $("#selectequipmentHistory").click(function(){
      var pageid = "selectequipmentHistory";
      if(pageid!=null){
          $("#contain").load("${pageContext.request.contextPath}/"+pageid+".do");
      }
  });

  $("#addequipment").click(function(){
	  $("#addmymodal").modal("show");
  });

  $("#addInfo").click(function(){
	  var add_id=$("#id_add").val();
	  if(add_id==null||add_id==""){
             alert("设备编码不能为空");
             return;
		  }
      var add_name=$("#name_add").val();
      if(add_name==null||add_name==""){
           alert("设备名称不能为空");
           return;
          }
      var add_floorid=$("#floorid_add").val();
      if(add_floorid==null||add_floorid==""){
          alert("楼层不能为空");
          return;
          }
      var add_line=$("#line_add").val();
      if(add_line==null||add_line==""){
    	  alert("线体不能为空");
          return;
          }
      var add_status=$("#status_add:checked").val();
      if(add_status==null||add_status==""){
    	  alert("状态不能为空");
          return;
          }
      var add_remarks=$("#remarks_add").val();
      if(add_remarks==null||add_remarks==""){
    	  alert("备注不能为空");
          return;
          }
      var parameters={
          id:add_id,
          name:add_name,
          floorid:add_floorid,
          line:add_line,
          status:add_status,
          remarks:add_remarks,
    	      };
     var data={
    	     action:"addEquipmentInfo",
    	     msg:JSON.stringify(parameters),
    	     };

      var address='${pageContext.request.contextPath}/addEquipmentInfo.do';
      var type='post';
      var jsondata = JSON.stringify(data);
      var callbackfunction = function(resdata){
           if(resdata.result_signal !="ok"){
        	   alert(resdata.result);
               }else{
                   var res=add_id+" 录入成功！"
                   $("#successid").text(res);
            	  
                   }
          };
          useajax(address, type, jsondata, callbackfunction);
  });

  /* 线体的维护 */
  $("#findaddline").click(function(){
	  $("#findAddLine").modal("show");
  });
  
  $("#addLineInfo").click(function(){
     var line=$("#findAdd_line").val();
     var data={
    	     action:"addline",
    	     msg:line
    	     };
      var address='${pageContext.request.contextPath}/addline.do';
      var type='post';
      var jsondata = JSON.stringify(data);
      var callbackfunction = function(resdata){
           if(resdata.result_signal !="ok"){
        	   alert(resdata.result);
               }else{
                   var res=line+" 录入成功！"
                   $("#successline").text(res);
            	  
                   }
          };
          useajax(address, type, jsondata, callbackfunction);
	  });
  $("#selectLineInfo").click(function(){
	  var line=$("#findAdd_line").val();
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
	            	   $("#lineshow").empty();
	                    for(var i=0;i<selector.length;i++){
	                        $("#lineshow").append("<lable><hr>"+selector[i]+"</hr></lable><br/>");
	                    }
	            	  
	                   }
	          };
	          useajax(address, type, jsondata, callbackfunction);

	  });
  
  /* 楼层的维护 */
  $("#findaddfloor").click(function(){
	  $("#findAddfloor").modal("show");
  });
  
  $("#addFloorInfo").click(function(){
	  
     var floorid=$("#findAdd_floorid").val();
     var data={
    	     action:"addfloorid",
    	     msg:floorid
    	     };
      var address='${pageContext.request.contextPath}/addFloor.do';
      var type='post';
      var jsondata = JSON.stringify(data);
      var callbackfunction = function(resdata){
           if(resdata.result_signal !="ok"){
        	   alert(resdata.result);
               }else{
                   var res=floorid+" 录入成功！"
                   $("#successfloor").text(res);
            	  
                   }
          };
          useajax(address, type, jsondata, callbackfunction);
	  });
  $("#selectFloorInfo").click(function(){
	  var floorid=$("#findAdd_floorid").val();
	     var data={
	    	     action:"findline",
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
	            	    $("#floorshow").empty();
	                    for(var i=0;i<selector.length;i++){

	                        $("#floorshow").append("<lable><hr>"+selector[i]+"</hr></lable><br/>");
	                    }
	            	  
	                   }
	          };
	          useajax(address, type, jsondata, callbackfunction);

	  });

  
  $("#quit").click(function(){
	  window.location.href = "${pageContext.request.contextPath}/loginoff.do";
  });

  getLineInfo();
  function getLineInfo(){
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
                        $("#line_add").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
                        //$("#line_input").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
                    }
                   }
          };
          useajax(address, type, jsondata, callbackfunction);
	  }
  getFloorInfo();
  function getFloorInfo(){
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
                        $("#floorid_add").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
                        //$("#line_input").append("<option value='"+selector[i]+"'>"+selector[i]+"</option>");
                    }
                   }
          };
          useajax(address, type, jsondata, callbackfunction);
	  }
  	
});

</script>
<body style="width: 100%; height: 100%;">
	<div class="top_layout top_theme">
		<label class="top_font" style="margin-left: 70px">SmartFactory</label>
	</div>
	<div class="boy_layout boy_theme">
	   <!-- 标题栏 -->
	 <div>
	 <ul>
    <li><a id="" class="active" >主页</a></li>
    <li><a id="selectequipment" class="">信息查询</a></li>
    <li><a id="selectequipmentHistory" class="">详细查询</a></li>
    <li><a id="addequipment" class="">信息录入</a></li>
    <li><a id="findaddline" class="">线体录入</a></li>
    <li><a id="findaddfloor" class="">楼层录入</a></li>
    <li><a id="quit" class="">退出</a></li>
    </ul>
    </div>
    
    <div id="addmymodal"
<%--调用拟态框类、淡入淡出效果--%>
     class="modal fade " tabindex="-1" role="dialog" style="margin-top: 20rem " 
     aria-labelledby="mymodallable" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" >
                <div class="contain">
                <div class="modal-font" > 信息的录入</div>
                    <table align ="center">
     
                    <tr>
                     <td>设备编码</td>
                     <td><input id="id_add" type="text" class="" ></td>
                    </tr>
                    <tr>
                     <td>设备名称</td>
                     <td><input id="name_add" type="text" class="" ></td>
                    </tr>
                    <tr>
                     <td>楼层号</td>
                     <td><select id="floorid_add" type="text" class="" style="width: 150px" >
                     </select>
                     
                     
                     </td>
                    </tr>
                    <tr>
                     <td>线体</td>
                     <td><select id="line_add" type="text" class=""  style="width: 150px"  overflow-y: scroll>
                     </select></td>
                    </tr>
                    <tr>
                     <td>状态</td>
                     <td><label><input id="status_add" name="1" type="radio" class=""  value="在用"/>在用
                     <input id="status_add" name="1" type="radio" class="" checked="checked" value="空闲"/>空闲
                     <input id="status_add"  name="1" type="radio" class="" value="报废"/>报废</label>
                     
                     </td>
                    </tr>
                    <tr>
                     <td>备注</td>
                     <td><textarea id="remarks_add"  class="" style="height: 6rem"></textarea></td>
                    </tr>
                    
                    </table>
                </div>
            </div>
            <div class="modal-footer">
               <label id="successid" style="color: #00ff00"  ></label>
                <a id="addInfo" class="btn btn-primary">保存</a>
                <a class="btn btn-default" data-dismiss="modal">取消</a>
            </div>
        </div>
    </div>
	 </div>
	 
	  <div id="findAddLine"
<%--调用拟态框类、淡入淡出效果--%>
     class="modal fade " tabindex="-1" role="dialog" style="margin-top: 20rem " 
     aria-labelledby="mymodallable" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" >
                <div class="contain">
                <div class="modal-font" >线体的录入</div>
                    <table align ="center">
                    <tr>
                     <td>线体</td>
                     <td><input id="findAdd_line" type="text" class="" ></td>
                    </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
               <label id="successline" style="color: #00ff00"  ></label>
                <a id="addLineInfo" class="btn btn-primary">保存</a>
                <a id="selectLineInfo" class="btn btn-primary">查询</a>
                <a class="btn btn-default" data-dismiss="modal">取消</a>
            </div>
            <div id="lineshow"  style="height: 20rem;overflow-y: scroll">
	       </div> 
        </div>
    </div>
	 </div>
	 
	 	  <div id="findAddfloor"
<%--调用拟态框类、淡入淡出效果--%>
     class="modal fade " tabindex="-1" role="dialog" style="margin-top: 20rem " 
     aria-labelledby="mymodallable" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" >
                <div class="contain">
                <div class="modal-font" >楼层的录入</div>
                    <table align ="center">
                    <tr>
                     <td>楼层</td>
                     <td><input id="findAdd_floorid" type="text" class="" ></td>
                    </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
               <label id="successfloor" style="color: #00ff00"  ></label>
                <a id="addFloorInfo" class="btn btn-primary">保存</a>
                <a id="selectFloorInfo" class="btn btn-primary">查询</a>
                <a class="btn btn-default" data-dismiss="modal">取消</a>
            </div>
            <div id="floorshow"  style="height: 20rem;overflow-y: scroll">
	       </div> 
        </div>
    </div>
	 </div>
         <%--内容--%>
            <div id="contain" class="col-md-12 no-marging-padding">
            </div>
	  </div>
	  
	  
	  
	<div class="floor_layout floor_theme" >
		<label class="floor_font">版权所有：上海斐讯数据通信有限公司</label>
	</div>
</body>
</html>