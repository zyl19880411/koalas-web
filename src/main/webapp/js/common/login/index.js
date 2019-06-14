$(document).ready(
		function() {

			/*
			 * var myDate = new Date(); var mytime=myDate.toLocaleTimeString();
			 * $("#time").html("现在时间:" + mytime)
			 * 
			 * setInterval(function(){ var myDate = new Date(); var
			 * mytime=myDate.toLocaleTimeString(); $("#time").html("现在时间:" +
			 * mytime) },1000);
			 */

			// $("#aa").append("<div title=\"人员管理1\"
			// data-options=\"iconCls:'icon-feed_key',border:false\"
			// style=\"overflow: auto; padding: 10px;\"><ul
			// style=\"padding:0px\"><li tabtitle=\"系统管理1\"><div><a
			// target=\"mainFrame\" ><span class=\"icon icon-users\"
			// ></span>系统管理</a></div></li></ul></div>");
			$('#tt').tabs({
				onContextMenu : function(e, title, index) {
					e.preventDefault();
					$("#mm").menu("show", {
						left : e.pageX,
						top : e.pageY
					}).data("tabTitle", title).data("tabindex", index);
				}
			});
			$("#mm").menu({
				onClick : function(item) {
					var curTabTitle = $(this).data("tabTitle");
					var index = $(this).data("tabindex");
					// 关闭当前
					if (item.name == 'close') {
						$('#tt').tabs("close", curTabTitle);
					}

					// 关闭全部
					else if (item.name == 'closeAll') {
						var len = $('#tt').tabs("tabs").length;
						for (var i = len - 1; i >= 0; i--) {
							$('#tt').tabs("close", i);
						}
						/*
						 * var allTabs = $("#tt").tabs("tabs");
						 * 
						 * $.each(allTabs,function () {
						 * 
						 * var opt = $(this).panel("options"); alert(opt.title)
						 * });
						 */
					}
					// 关闭其他tab
					else if (item.name == 'closeOther') {
						var len = $('#tt').tabs("tabs").length;
						for (var i = len - 1; i >= 0; i--) {
							if (i != index) {
								$('#tt').tabs("close", i);
							}

						}
					}

					// 关闭左侧tab
					else if (item.name == 'closeLeft') {
						var len = $('#tt').tabs("tabs").length;
						for (var i = len - 1; i >= 0; i--) {
							if (i < index) {
								$('#tt').tabs("close", i);
							}

						}
					}

					// 关闭右侧tab
					else if (item.name == 'closeRight') {
						var len = $('#tt').tabs("tabs").length;
						for (var i = len - 1; i >= 0; i--) {
							if (i > index) {
								$('#tt').tabs("close", i);
							}

						}
					}
				}
			});

			/*
			 * $('.easyui-accordion li a').hover( function(){
			 * $(this).parent().addClass("hover"); },function(){
			 * $(this).parent().removeClass("hover"); });
			 */
            $('#tt').tabs('add', {
                title : "主页",
                selected : true,
                content:'<iframe scrolling="yes"  frameborder="0" src="'+ $("#basePath").val() + "hfhome/page.do" + '"  style="width:100%;height:100%;position: absolute;"></iframe>',
                closable : false,
                iconCls : "icon-house",
                id:"hfhome",
                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler:function(){
                    	var options = $("#hfhome").panel('options');
                         $('#hfhome').panel(options);
                    }
                }
                ]
            });

			$("[name='btn']").click(
					function() {
						$("[name='btn']").css("background-color", "");
						$(this).siblings().css("background-color", "").end()
								.css("background-color", "#99BBE8")
						// $(this).css("background-color","#99BBE8");
						/*
						 * $(this).parents("ul").siblings().find(".click").removeClass("click");
						 * $(this).parent().addClass("click"); var title =
						 * $(this).parents("li").attr("tabtitle"); var
						 * ltabdialog =
						 * $(this).parents("li").attr("tabdialog").split(",");
						 * 
						 * $('#tt').tabs({ onAdd:function(title,index){
						 * 
						 * for(var i =0;i<ltabdialog.length;i++){ var tabdialog =
						 * ltabdialog[i]; $('#'+tabdialog).dialog('destroy',
						 * true); } } });
						 */
						var title = $(this).attr("tabtitle");
						var url = $(this).attr("url");
						var icon = $(this).attr("icon");
						// add a unselected tab panel
						if (!$('#tt').tabs('exists', title)) {
							
							if(url == "druid"){
								$('#tt').tabs('add', {
									title : title,
									selected : true,
									content:'<iframe scrolling="yes" frameborder="0" src=" ' + $("#basePath").val()+url+'"  style="width:100%;height:100%;"></iframe>',
									closable : true,
									iconCls : icon
								});
							}
							else{
								$('#tt').tabs('add', {
									title : title,
									selected : true,
									// content:'<iframe scrolling="yes"
									// frameborder="0"
									// src="UploadDataController/loadData"
									// style="width:100%;height:100%;"></iframe>',
									closable : true,
									iconCls : icon,
									href : url,
									id:title,
									tools:[{
						    					iconCls:'icon-mini-refresh',
						    					handler:function(){$("#" + title).panel('refresh');}
						    				}
						    	    ]
								});
							}
						} else {
							$('#tt').tabs('select', title);
						}

						$(".tabs-inner").on("dblclick", function() {
							var subtitle = $(this).children("span").text();
							$('#tt').tabs('close', subtitle);
						});

					});

			/*
			 * $("#logout").click(function(){ location.href = 'login/logout';
			 * });
			 * 
			 * $("#refish").click(function(){ location.href = 'login/userLogin';
			 * });
			 */

			$("#skin").combobox(
					{
						data : [ {
							id : 'black',
							text : 'black'
						}, {
							id : 'bootstrap',
							text : 'bootstrap'
						}, {
							id : 'default',
							text : 'default'
						}, {
							id : 'gray',
							text : 'gray'
						}, {
							id : 'metro',
							text : 'metro'
						}, {
							id : 'metro-blue',
							text : 'metro-blue'
						}, {
							id : 'metro-green',
							text : 'metro-green'
						}, {
							id : 'metro-orange',
							text : 'metro-orange'
						}, {
							id : 'metro-red',
							text : 'metro-red'
						}, {
							id : 'ui-cupertino',
							text : 'ui-cupertino'
						}, {
							id : 'ui-dark-hive',
							text : 'ui-dark-hive'
						}, {
							id : 'ui-pepper-grinder',
							text : 'ui-pepper-grinder'
						}, {
							id : 'ui-sunny',
							text : 'ui-sunny'
						} ],
						onSelect : function(aa) {
							$("#themes").attr(
									"href",
									$("#basePath").val() + 'easyui/themes/'
											+ aa.id + '/easyui.css')
						}
					});

			$("#west").prev("div").find(">.panel-title").css({"height":"19px","line-height":"19px"});
			$("#menu > div:last > div:last").css("border-bottom","0px");
			
			var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }

		    var Minutes=date.getMinutes()<=9? '0' + date.getMinutes():date.getMinutes();
		    var Seconds=date.getSeconds()<=9? '0' + date.getSeconds():date.getSeconds();
		    
		    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + Minutes
		            + seperator2 + Seconds;
		    
			$.messager.show({
				title:'欢迎使用',
				msg:userName + '  您好<br>' +
				 '现在时间是:' +currentdate,
				showType:'show'
			});
			
			
			$("#menu").accordion({
		    	onSelect:function(title,index){
		    		 $("#menu").accordion("resize");
		    		
		    	},
			    onUnselect:function(title,index){
			    	$("#menu").accordion("resize");
					
				}
		    });

			var s = false;
            $("#allsk").click(function () {
            	if(!s){
                     fullScreen();
                    s=true;
				}else{
                     exitFull();
            		s=false;
				}

            });
            	

            function fullScreen() {

                var el = document.documentElement;

                var rfs = el.requestFullScreen || el.webkitRequestFullScreen ||

                    el.mozRequestFullScreen || el.msRequestFullScreen;

                if(typeof rfs != "undefined" && rfs) {

                    rfs.call(el);

                } else if(typeof window.ActiveXObject != "undefined") {

                    //for IE，这里其实就是模拟了按下键盘的F11，使浏览器全屏

                    var wscript = new ActiveXObject("WScript.Shell");

                    if(wscript != null) {

                        wscript.SendKeys("{F11}");

                    }

                }
            }

            function exitFull() {
                // 判断各种浏览器，找到正确的方法
                var exitMethod = document.exitFullscreen || document.mozCancelFullScreen || document.webkitExitFullscreen || document.webkitExitFullscreen;
                if (exitMethod) {
                    exitMethod.call(document);
                }
                else if (typeof window.ActiveXObject !== "undefined") {//for Internet Explorer
                    var wscript = new ActiveXObject("WScript.Shell");
                    if (wscript !== null) {
                        wscript.SendKeys("{F11}");
                    }
                }
            }

			
		});