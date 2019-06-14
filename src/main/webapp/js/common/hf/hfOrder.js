$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#hfOrderTable').datagrid({
        fit:true,
        pagination:true,
        nowrap: false,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        collapsible:false,
        fitColumns:false,
        singleSelect:true,
        method:'post',
        frozenColumns:[[
            {field:'check',align:'center',checkbox:true,width:15},
            {field:'id',title:'id',align:'center',width:100,hidden:true},
            {field:'docId',title:'docId',align:'center',width:100,hidden:true},
            {field:'studentName',title:'学生姓名',align:'center',width:100},
            {field:'studentPhone',title:'家长电话',align:'center',width:100},
        ]],
        columns:[[
                {field:'docName',title:'跟进人',align:'center',width:100},
                {field:'orgName',title:'所属组别',align:'center',width:100},
                {field:'studentId',title:'编号',align:'center',width:100},
                {field:'gaokaoYear',title:'高考年份',align:'center',width:100,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM");
                        } else{
                            return '';
                        }
                    }},
                {field:'loveSubject',title:'意向课程',align:'center',width:100,
                    formatter: function(value,row,index){
                        if (value == "1"){
                            return "数学";
                        } else if (value == "2"){
                            return "外语";
                        }else if (value == "3"){
                            return "物理";
                        }else if (value == "4"){
                            return "化学";
                        }else if (value == "5"){
                            return "生物";
                        }else if (value == "6"){
                            return "历史";
                        }else if (value == "7"){
                            return "地理";
                        }else if (value == "8"){
                            return "政治";
                        }else if (value == "9"){
                            return "其他";
                        }else if (value == "0"){
                            return "语文";
                        }else{
                            return "";
                        }
                    }},
                {field:'channel',title:'渠道',align:'center',width:100},
                {field:'ifListener',title:'是否试听',align:'center',width:100,
                    formatter: function(value,row,index){
                        return getStateComment(value);
                    }},
                {field:'ifSuccess',title:'是否已经成单',align:'center',width:100,
                    formatter: function(value,row,index){
                        return getStateComment(value);
                    }},
                {field:'ifError',title:'数据是否有效',align:'center',width:100,
                    formatter: function(value,row,index){
                        return getStateComment(value);
                    }},
                {field:'ifIntroduction',title:'是否是转介绍',align:'center',width:100,
                    formatter: function(value,row,index){
                        return getStateComment(value);
                    }},
                {field:'introductionType',title:'转介绍类型',align:'center',width:100,
                    formatter: function(value,row,index){
                        if(value == '1'){
                            return '公司员工转介绍';
                        } else if(value == '2'){
                            return '用户转介绍';
                        } else{
                            return '';
                        }
                    }},
			    {field:'introductionId',title:'转介绍人',align:'center',width:100},
                {field:'cTime',title:'录入时间',align:'center',width:150,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                           return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                        } else{

                            return '';
                        }
                    }},
                {field:'uTime',title:'更新时间',align:'center',width:150,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")

                        } else{
                            return '';
                        }
                    }},
                {field:'backup',title:'备注',align:'center',width:600,formatter: function(value,row,index){
                        return value.replace(/\r\n/g,'<br>')
                    }

                }
        ]],
        toolbar:'#hfOrderTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#hfOrderTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#hfOrderTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   $('#hfOrderTable').datagrid({
		   url:'order/getOrders.do',
           queryParams: {
               'studentId':'',
               'studentName': '',
               'studentPhone':'',
               'docName':'',
               'orgName':'',
               'ctime_from':'',
               'ctime_to':'',
               'hforderisme':'n'
           }
	   });

	 //********************表格自适应end************************************************
	   
	   //$(window).height(); //浏览器当前窗口可视区域高度
	   //$(document).height(); //浏览器当前窗口文档的高度
	   //$(document.body).height();//浏览器当前窗口文档body的高度
	   //$(document.body).outerHeight(true);//浏览器当前窗口文档body的总高度 包括border padding margin
	   //$(window).width(); //浏览器当前窗口可视区域宽度
	   //$(document).width();//浏览器当前窗口文档对象宽度
	   //$(document.body).width();//浏览器当前窗口文档body的高度
	   //$(document.body).outerWidth(true);//浏览器当前窗口文档body的总宽度 包括border padding margin 
	   
    //*****************************主页面表格加载结束*****************************

    //********************查询begin************************************************
    $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click(function(){
        var options = $('#hfOrderTable').datagrid('options');
        options.url='order/getOrders.do';

        var hforderisme;
        if($("#hforderisme").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        $('#hfOrderTable').datagrid('load',{
            'studentId': $("#studentId").val(),
            'studentName': $("#studentName").val(),
            'studentPhone': $("#studentPhone").val(),
            'docName': $("#docName").val(),
            'orgName': $("#orgName").val(),
            'ctime_from':$('#ctime_from').datebox('getValue'),
            'ctime_to':$('#ctime_to').datebox('getValue'),
            'hforderisme':hforderisme
        });
    })
    //********************查询end************************************************

    //********************导入表格begin************************************************
    $("#4w3fHyS1IG6gI1zbrz6m8ma57LokazJY").click(function(){

        var hforderisme;
        if($("#hforderisme").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        var url = $("#basePath").val();
        url = url + "order/export.do?" +
            "studentId=" + $("#studentId").val() + "&"+
            "studentName=" + $("#studentName").val() + "&"+
            "studentPhone=" + $("#studentPhone").val() + "&"+
            "docName=" + $("#docName").val() + "&"+
            "orgName=" + $("#orgName").val() + "&"+
            "ctime_from=" + $('#ctime_from').datebox('getValue') + "&"+
            "ctime_to=" + $('#ctime_to').datebox('getValue') + "&"+
            "hforderisme=" + hforderisme + "&" +
            "v="+ Math.random();
        location.href =url;

    })
    //********************导入表格end************************************************


    //********************添加begin************************************************
    $("#ORnIfXHz8afqX4FkygFQOc5DDe301YY4").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrderdialog").length == 0){
            $("#hfOrderdiv").html("<div id='hfOrderdialog' name='hfOrderdialog'></div>");
        }
        showdialog("add");
    })
    //********************添加end************************************************

    //********************修改begin************************************************
    $("#kfnoQC2eKETjNbB6Eq177j6EdRxrliaU").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrderdialog").length == 0){
            $("#hfOrderdiv").html("<div id='hfOrderdialog' name='hfOrderdialog'></div>");
        }
        showdialog("save");
    })
    //********************修改end************************************************

    //********************转介绍begin************************************************
    $("#oUHfs18Wg4MfvLseh6fFiE5yFID5ceaA").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrderintroductiondialog").length == 0){
            $("#hfOrderintroductiondiv").html("<div id='hfOrderintroductiondialog' name='hfOrderintroductiondialog'></div>");
        }
        showintroductiondialog();
    })
    //********************转介绍end************************************************

    //********************空错号begin************************************************
    $("#4BxadSTePjrsIrdt8s3KSPfu3ihVsVfC").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrdererrordialog").length == 0){
            $("#hfOrdererrordiv").html("<div id='hfOrdererrordialog' name='hfOrdererrordialog'></div>");
        }
        showErrordialog();
    })
    //********************空错号end************************************************


    function showErrordialog(){
        var row= $('#hfOrderTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        if(row.ifError == '0'){
            $.messager.alert('提示消息','此学生是空错号,无需再次选择','warning');
            return false;
        }

        if(row.ifListener == '1'){
            $.messager.alert('提示消息','此学生已经试听,无法设置为空错号','warning');
            return false;
        }

        if(row.ifSuccess == '1'){
            $.messager.alert('提示消息','此学生已经成单,无法设置为空错号','warning');
            return false;
        }

        var id = row!=null?row.id:'';

        var href = encodeURI(encodeURI('order/error.do?'
            +"id=" + id
        ));

        //显示dilog
        $('#hfOrdererrordialog').dialog({
            title: "无效设置",
            width: 450,
            height: 180,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfOrdererrordialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    $.messager.confirm('确认',"确认设置为无效数据吗。此操作不可恢复",function(r){
                        if (r){
                            saveerror();
                        }else{
                            $.messager.alert('取消设置为无效数据','您已经取消设置为无效数据!','warning');
                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfOrdererrordialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfOrdererrordialog').dialog('destroy', true)
            }
        });
    }

    function saveerror() {

        if(checkError()){
            $.ajax({
                type:'post',
                url:'order/adderror.do',
                data:decodeURIComponent($("#hforderErrorFrom").serialize(),true) + "&addhfErrorType=" + $("#hfErrorType").slider('getValue'),
                cache:false,
                success:function(data,textStatus,XMLHttpRequest){
                    if(data=='addSuccess'){
                        $.messager.alert('成功','设置成功!','info',function(){
                            $('#hfOrdererrordialog').dialog('close');
                            $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                        });
                    } else{
                        $.messager.alert('失败','设置失败,请联系管理员!','error');
                    }
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('失败','设置失败,请联系管理员!','error');
                }
            });
        }
    }

    function checkError(){
        //判断转介绍类型
        var hfErrorType = $("#hfErrorType").slider('getValue');
        if(hfErrorType =="" || hfErrorType ==null||hfErrorType ==0){
            $.messager.alert('提示消息','请选择无效类型!','warning');
            return false;
        }
        return true
    }

    function  showintroductiondialog(){

        var row= $('#hfOrderTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        if(row.ifError == '0'){
            $.messager.alert('提示消息','此学生是空错号，无法设置转介绍人','warning');
            return false;
        }

        var id = row!=null?row.id:'';

        var href = encodeURI(encodeURI('order/introduction.do?'
            +"id=" + id
        ));

        //显示dilog
        $('#hfOrderintroductiondialog').dialog({
            title: "转介绍",
            width: 450,
            height: 210,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfOrderintroductiondialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){

                    $.messager.confirm('确认',"确认转介绍吗",function(r){
                        if (r){
                            saveintroductionSuccess();
                        }else{
                            $.messager.alert('取消转介绍','您已经取消转介绍!','warning');
                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfOrderintroductiondialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfOrderintroductiondialog').dialog('destroy', true)
            }
        });
    }

      function saveintroductionSuccess(){

          if(Checkintroduction()){
              $.ajax({
                  type:'post',
                  url:'order/addintroduction.do',
                  data:decodeURIComponent($("#hforderintroductionFrom").serialize(),true) + "&addhfhfintroductionType=" + $("#hfintroductionType").slider('getValue'),
                  cache:false,
                  success:function(data,textStatus,XMLHttpRequest){
                      if(data=='addSuccess'){
                          $.messager.alert('转介绍成功','客户转介绍成功!','info',function(){
                              $('#hfOrderintroductiondialog').dialog('close');
                              $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                          });
                      } else{
                          $.messager.alert('转介绍失败','客户转介绍失败,请联系管理员!','error');
                      }
                  },
                  error:function(XMLHttpRequest, textStatus, errorThrown){
                      $.messager.alert('转介绍失败','客户转介绍失败,请联系管理员!','error')
                  }
              });
          }
      }

      function Checkintroduction(){

          //判断转介绍类型
          var hfintroductionType = $("#hfintroductionType").slider('getValue');
          if(hfintroductionType =="" || hfintroductionType ==null||hfintroductionType ==0){
              $.messager.alert('提示消息','请选择转介绍类型!','warning');
              return false;
          }

          //判断转介绍人是否正确
          var hfintroductionName = $("#hfintroductionName").val();
          if(hfintroductionName =="" || hfintroductionName ==null){
              $.messager.alert('提示消息','转介绍人不能为空!','warning');
              return false;
          }

        return true;
      }


    //********************删除begin************************************************
    $("#DhmR0OdVOiJ8BtWbSNasWRO7OG6TuITm").click(function(){

        var row=$('#hfOrderTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        $.messager.confirm('确认',"确认删除吗",function(r){
            if (r){

                $.ajax({
                    type:'post',
                    url:'order/del.do',
                    data:{'id':row.id},
                    cache:false,
                    success:function(data,textStatus,XMLHttpRequest){
                        if(data=='delsuccess'){
                            $.messager.alert('删除成功','订单删除成功!','info',function(){
                                $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                            });
                        };
                        if(data=='delerror'){
                            $.messager.alert('删除失败','删除失败请联系管理员!','warning');
                        };
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                        $.messager.alert('删除失败','订单删除错误!','error')
                    }
                });


            }else{
                $.messager.alert('取消删除','您已经取消删除!','warning');
            }
        });


    })
    //********************删除end************************************************


    //********************试听begin************************************************
    $("#AKvC3hCyEHAIGw1odhpVNoNXJ0kETxUA").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrderLisdialog").length == 0){
            $("#hfOrderLisdiv").html("<div id='hfOrderLisdialog' name='hfOrderLisdialog'></div>");
        }
        showLisdialog();
    })
    //********************试听end************************************************


    //********************成单begin************************************************
    $("#E0Hl7uzefZYdNa3nM0CpICFw2XPnpk77").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfOrdersuccessdialog").length == 0){
            $("#hfOrdersuccessdiv").html("<div id='hfOrdersuccessdialog' name='hfOrdersuccessdialog'></div>");
        }
        showSuccessdialog();
    })

    //********************成单end************************************************
    function showSuccessdialog(){
        var row= $('#hfOrderTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        if(row.ifSuccess == '1'){
            $.messager.alert('提示消息','此学生已经成单，若想修改，请去成单页面','warning');
            return false;
        }

        if(row.ifError == '0'){
            $.messager.alert('提示消息','此学生是空错号，无法成单','warning');
            return false;
        }

        var id = row!=null?row.id:'';

        var href = encodeURI(encodeURI('order/success.do?'
            +"id=" + id
        ));

        //显示dilog
        $('#hfOrdersuccessdialog').dialog({
            title: "成单",
            width: 600,
            height: 385,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfOrdersuccessdialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){

                    $.messager.confirm('确认',"确认成单吗",function(r){
                        if (r){
                            saveSuccess();
                        }else{
                            $.messager.alert('取消成单','您已经取消成单!','warning');
                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfOrdersuccessdialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfOrdersuccessdialog').dialog('destroy', true)
            }
        });

    }

    function saveSuccess(){

        if(Checkuccess()){
            $.ajax({
                type:'post',
                url:'order/addSuccess.do',
                data:decodeURIComponent($("#hforderSuccessFrom").serialize(),true) + "&addhfclassHour=" + $("#hfclassHour").slider('getValue'),
                cache:false,
                success:function(data,textStatus,XMLHttpRequest){
                    if(data=='addSuccess'){
                        $.messager.alert('成单成功','客户成单成功!','info',function(){
                            $('#hfOrdersuccessdialog').dialog('close');
                            $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                        });
                    }else if(data =='successContains'){
                        $.messager.alert('成单失败','合同编号存在!','error');
                    } else{
                        $.messager.alert('成单失败','客户成单失败,请联系管理员!','error');
                    }
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('添加失败','客户成单失败,请联系管理员!','error')
                }
            });
        }
    }

    function Checkuccess(){

        //试听关单时间
        var hfcloseVTime = $("#hfcloseVTime").datetimebox('getValue');
        if(hfcloseVTime == null || hfcloseVTime ==''){
            $.messager.alert('提示消息','试听关单时间不能为空!','warning');
            return false;
        }

        //判断编号是否正确
        var hfcontractNumbe = $("#hfcontractNumbe").val();
        if(hfcontractNumbe =="" || hfcontractNumbe ==null){
            $.messager.alert('提示消息','合同编号不能为空!','warning');
            return false;
        }

        //判断成单课时
        var hfclassHour = $("#hfclassHour").slider('getValue');
        if(hfclassHour =="" || hfclassHour ==null||hfclassHour ==0){
            $.messager.alert('提示消息','成单课时不能为0!','warning');
            return false;
        }

        //成单金额
        var hforderMoney = $("#hforderMoney").val();
        var reg = /^[0-9]+(\.[0-9]{0,2})?$/
        if(!reg.test(hforderMoney)){
            $.messager.alert('提示消息','成单金额不正确!','warning');
            return false;
        }

        //判断支付方式是否正确
        var hfpayStatus = $("#hfpayStatus").val();
        if(hfpayStatus =="" || hfpayStatus ==null){
            $.messager.alert('提示消息','支付方式不能为空!','warning');
            return false;
        }

        //支付时间
        var hfpayTime = $("#hfpayTime").datetimebox('getValue');
        if(hfpayTime == null || hfpayTime ==''){
            $.messager.alert('提示消息','支付时间不能为空!','warning');
            return false;
        }
        return true;
    }


    function showLisdialog(){
        var row= $('#hfOrderTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        if(row.ifListener == '1'){
            $.messager.alert('提示消息','此学生已经试听，若想修改，请去试听页面','warning');
            return false;
        }

        if(row.ifError == '0'){
            $.messager.alert('提示消息','此学生是空错号，无法试听','warning');
            return false;
        }

        var id = row!=null?row.id:'';

        var href = encodeURI(encodeURI('order/listen.do?'
            +"id=" + id
        ));

        //显示dilog
        $('#hfOrderLisdialog').dialog({
            title: "试听",
            width: 600,
            height: 385,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfOrderLisdialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){

                    $.messager.confirm('确认',"确认试听吗",function(r){
                        if (r){
                             saveListen();
                         }else{
                            $.messager.alert('取消试听','您已经取消试听!','warning');

                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfOrderLisdialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfOrderLisdialog').dialog('destroy', true)
            }
        });

    }

    function saveListen(){

        if(checkListen()){
            $.ajax({
                type:'post',
                url:'order/addListen.do',
                data:decodeURIComponent($("#hforderListenFrom").serialize(),true),
                cache:false,
                success:function(data,textStatus,XMLHttpRequest){
                    if(data=='addSuccess'){
                        $.messager.alert('试听成功','客户试听成功!','info',function(){
                            $('#hfOrderLisdialog').dialog('close');
                            $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                        });
                    };
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('添加失败','添加试听错误!','error')
                }
            });
        }
    }

    function checkListen(){
        //试听课程
        var hflistenSubject = $("#hflistenSubject").combobox("getValue");

        if(hflistenSubject == null || hflistenSubject ==''){
            $.messager.alert('提示消息','试听课程不能为空!','warning');
            return false;
        }

        //试听时间
        var hflistenTime = $("#hflistenTime").datebox('getValue');
        if(hflistenTime == null || hflistenTime ==''){
            $.messager.alert('提示消息','试听时间不能为空!','warning');
            return false;
        }

        //判断教师姓名是否正确
        var hfteacherName = $("#hfteacherName").val();
        if(hfteacherName =="" || hfteacherName ==null){
            $.messager.alert('提示消息','教师姓名不能为空!','warning');
            return false;
        }

        //判断教师电话是否正确
        var hfteacherPhone = $("#hfteacherPhone").val();
        var reg=/^[0-9]{11}$/;
        if(!reg.test(hfteacherPhone)){
            $.messager.alert('提示消息','教师电话号格式不正确!','warning');
            return false;
        }
        return true;
    }

    //*****************************添加修改弹出dialog start*****************************///
    function showdialog(addOrSave){

        var title='新用户添加';
        var row;
        if('save'==addOrSave){
            title = "用户修改",
                row = $('#hfOrderTable').datagrid('getSelected');
            if(row==null){
                $.messager.alert('提示消息','请选择!','warning');
                return false;
            }
        }

        var id = row!=null?row.id:'';
        var studentName = row!=null?row.studentName:'';
        var studentPhone = row!=null?row.studentPhone:'';
        var studentId = row!=null?row.studentId:'';
        var gaokaoYear;

        if(row != null && row.gaokaoYear != null){
            gaokaoYear = new Date(row.gaokaoYear.time).Format("yyyy-MM")
        } else{
            gaokaoYear = '';
        }

        var loveSubject = row!=null?row.loveSubject:'';
        var channel = row!=null?row.channel:'';
        var backup = row!=null?row.backup:'';

        var href = encodeURI(encodeURI('order/'+addOrSave +".do?"
            +"id=" + id + "&"
            +"studentName=" + studentName + "&"
            +"studentPhone=" + studentPhone + "&"
            +"studentId=" + studentId + "&"
            +"gaokaoYear=" + gaokaoYear + "&"
            +"loveSubject=" + loveSubject + "&"
            +"channel=" + channel + "&"
            +"backup=" + backup
            ));

        //显示dilog
        $('#hfOrderdialog').dialog({
            title: title,
            width: 600,
            height: 385,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfOrderdialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){

                    var t ;
                    if('save'==addOrSave){
                        t="您确认修改吗?";
                    }
                    else{
                        t="您确认添加吗?";

                    }
                    $.messager.confirm('确认',t,function(r){
                        if (r){
                            save(addOrSave);
                        }else{
                            $.messager.alert('取消修改','您已经取消修改!','warning');

                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfOrderdialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfOrderdialog').dialog('destroy', true)
            }
        });

    }
    //*****************************添加修改弹出dialog end*****************************///

    //*****************************添加 begin*****************************///
    function save(addOrsave){
        if(checkOrderInfo()){
            $.ajax({
                type:'post',
                url:'order/addOrsave.do',
                data:decodeURIComponent($("#hforderFrom").serialize() + '&addOrSave=' + addOrsave,true),
                cache:false,
                success:function(data,textStatus,XMLHttpRequest){
                    if(data=='addSuccess'){
                        $.messager.alert('添加成功','客户添加成功!','info',function(){
                            $('#hfOrderdialog').dialog('close');
                            $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                        });
                    };
                    if(data=='orderContains'){
                        $.messager.alert('添加失败','客户编号重复!','warning');
                    };

                    if(data=='updateSuccess'){
                        $.messager.alert('修改成功','客户修改成功!','info',function(){
                            $('#hfOrderdialog').dialog('close');
                            $("#3KYFxo0cTAk6I8iBUseorwKID8luvvMr").click();
                        });
                    };

                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('添加失败','用户添加错误!','error')
                }
            });

        }
    }

    //*****************************添加修改弹出dialog end*****************************///

    //*****************************添加修改check begin*****************************///
      function checkOrderInfo(){

          //判断学生姓名是否正确
          var hfusername = $("#hfusername").val();
          if(hfusername =="" || hfusername ==null){
              $.messager.alert('提示消息','学生姓名不能为空!','warning');
              return false;
          }

          //判断学生电话是否正确
          var hfuserphone = $("#hfuserphone").val();
          var reg=/^[0-9]{11}$/;
          if(!reg.test(hfuserphone)){
              $.messager.alert('提示消息','手机号格式不正确!','warning');
              return false;
          }

          //判断编号是否正确
          var studentId = $("#hfstudentId").val();
          if(studentId =="" || studentId ==null){
              $.messager.alert('提示消息','请输入编号!','warning');
              return false;
          }

          return true;
      }
    //*****************************添加修改check end*****************************///

    //********************将状态flag转换成说明 start******************************************
    function  getStateComment(flag){
        if(flag=='0'){
            return "<img title='否' style=\"height:30px;width:30px;\" src=\""+  $("#basePath").val() + "icons/common/hf/no.png\">";
        }
        else if(flag=='1'){
            return "<img title='是' style=\"height:30px;width:30px;\" src=\""+  $("#basePath").val() + "icons/common/hf/yes.png\">";
        }
    }
    //********************将状态flag转换成说明 end******************************************

    //*****************************生日格式begin*****************************///
    $("#ctime_from").datebox({
        formatter : function(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
        },
        parser:function(s){
            var t = Date.parse(s);
            if (!isNaN(t)){
                return new Date(t);
            } else {
                return new Date();
            }
        }
    });
    //*****************************生日格式end*****************************///

    //*****************************生日格式begin*****************************///
    $("#ctime_to").datebox({
        formatter : function(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
        },
        parser:function(s){
            var t = Date.parse(s);
            if (!isNaN(t)){
                return new Date(t);
            } else {
                return new Date();
            }
        }
    });
    //*****************************生日格式end*****************************///
})