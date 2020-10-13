$(document).ready(function() {
	//*****************************主页面表格加载开始*****************************
    $('#hfOrderYearTable').datagrid({
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
                            return "未知";
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
        toolbar:'#hfOrderYearTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#hfOrderYearTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#hfOrderYearTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   $('#hfOrderYearTable').datagrid({
		   url:'order/getOrdersYear.do',
           queryParams: {
               'studentId':'',
               'studentName': '',
               'studentPhone':'',
               'docName':'',
               'orgName':'',
               'ctime_from':getYear(),
               'ctime_to':new Date().Format ("yyyy-MM-dd"),
               'hforderisme':'n'
           }
	   });

	   function getYear(){
           var d=new Date()
           d.setMonth(0);
           d.setDate(1);
           return d.Format ("yyyy-MM-dd");
       }

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
    $("#NyJja7vmmWsdBHst5rr2Zau7PjucqY4T").click(function(){
        var options = $('#hfOrderYearTable').datagrid('options');
        options.url='order/getOrdersYear.do';

        var hforderisme;
        if($("#hforderismeYear").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        $('#hfOrderYearTable').datagrid('load',{
            'studentId': $("#studentIdYear").val(),
            'studentName': $("#studentNameYear").val(),
            'studentPhone': $("#studentPhoneYear").val(),
            'docName': $("#docNameYear").val(),
            'orgName': $("#orgNameYear").val(),
            'ctime_from':getYear(),
            'ctime_to':new Date().Format ("yyyy-MM-dd"),
            'hforderisme':hforderisme
        });
    })
    //********************查询end************************************************

    //********************导入表格begin************************************************
    $("#GpJF6MurZsAxyxdviXvQSVtBlZ8SNHee").click(function(){

        var hforderisme;
        if($("#hforderismeYear").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        var url = $("#basePath").val();
        url = url + "order/exportYear.do?" +
            "studentId=" + $("#studentIdYear").val() + "&"+
            "studentName=" + $("#studentNameYear").val() + "&"+
            "studentPhone=" + $("#studentPhoneYear").val() + "&"+
            "docName=" + $("#docNameYear").val() + "&"+
            "orgName=" + $("#orgNameYear").val() + "&"+
            "ctime_from=" + getYear() + "&"+
            "ctime_to=" + new Date().Format ("yyyy-MM-dd") + "&"+
            "hforderisme=" + hforderisme + "&" +
            "v="+ Math.random();
        location.href =url;

    })
    //********************导入表格end************************************************

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
})