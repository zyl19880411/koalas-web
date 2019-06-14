<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--<script type="text/javascript" src="<%=basePath%>js/common/hf/hferrorListen.js"></script>--%>

<html style="background-color:#f1fbfd;color: #666">
<head>
	<meta charset="utf-8">
	<title>layuiAdmin 控制台主页一</title>
	<meta name="renderer" content="webkit">
	<base href="<%=basePath%>">
 	<meta http-equiv="x-ua-compatible" content="IE=edge",chrome=1 />
	<script type="text/javascript" charset="UTF-8" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="<%=basePath%>js/common/json/json2.js"></script>
	<script type="text/javascript" charset="UTF-8" src="<%=basePath%>js/common/inc/inc.js"></script>
	<script type="text/javascript" charset="UTF-8" src="<%=basePath%>js/common/home/echarts.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="<%=basePath%>css/common/hf/home/layuiadmin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="<%=basePath%>css/common/hf/home/layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md12">
			<div class="layui-row layui-col-space15">
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">个人今日数据详情</div>
						<div class="layui-card-body" style="height: 200px">
							<div class="layui-carousel layadmin-carousel layadmin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
								<div carousel-item="">
									<ul class="layui-row layui-col-space10 layui-this">
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>个人今日成单</h3>
												<p><cite>66</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>个人今日成单金额</h3>
												<p><cite>12</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>个人今日新客户</h3>
												<p><cite>99</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>个人今日邀约试听</h3>
												<p><cite>20</cite></p>
											</a>
										</li>
									</ul>
									<ul class="layui-row layui-col-space10">
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>待审友情链接</h3>
												<p><cite style="color: #FF5722;">5</cite></p>
											</a>
										</li>
									</ul>
								</div>
								<div class="layui-carousel-ind"></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>


						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">公司数据大盘</div>
						<div class="layui-card-body" style="height: 200px">

							<div class="layui-carousel layadmin-carousel layadmin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
								<div carousel-item="">
									<ul class="layui-row layui-col-space10 layui-this">
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>今日成单</h3>
												<p><cite>66</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>今日成单金额</h3>
												<p><cite>12</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>总成单</h3>
												<p><cite>99</cite></p>
											</a>
										</li>
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>总成单金额</h3>
												<p><cite>20</cite></p>
											</a>
										</li>
									</ul>
									<ul class="layui-row layui-col-space10">
										<li class="layui-col-xs6">
											<a href="javascript:;" class="layadmin-backlog-body">
												<h3>待审友情链接</h3>
												<p><cite style="color: #FF5722;">5</cite></p>
											</a>
										</li>
									</ul>
								</div>
								<div class="layui-carousel-ind"></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">其他內容</div>
						<div class="layui-card-body" style="height: 200px">
							<div id="main4" style="width: 100%;height:100%;"></div>

						</div>
					</div>
				</div>
				<div class="layui-col-md8">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">今日公司成单情况</div>
						<div class="layui-card-body" style="height: 400px">
							<div id="main" style="width: 100%;height:100%;"></div>
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">其他</div>
						<div class="layui-card-body" style="height: 160px">
							<div id="main1" style="width: 100%;height:100%;"></div>

						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" style="background-color: #d9dedc">其他</div>
						<div class="layui-card-body" style="height: 160px">
							<div id="main2" style="width: 100%;height:100%;"></div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">

    $(document).ready(function() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据

        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data:['新订单数','试听数量','成单数量','错误订单数量','跳票数量']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'新订单数',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'试听数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'成单数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'错误订单数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'跳票数量',
                    type:'line',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    areaStyle: {normal: {}},
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });


</script>

<script type="text/javascript">

    $(document).ready(function() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main1'));
        var data = genData(50);

        option = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                type: 'scroll',
                orient: 'vertical',
                right: 10,
                top: 20,
                bottom: 20,
                data: data.legendData,

                selected: data.selected
            },
            series : [
                {
                    name: '姓名',
                    type: 'pie',
                    radius : '55%',
                    center: ['40%', '50%'],
                    data: data.seriesData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };




        function genData(count) {
            var nameList = [
                '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
            ];
            var legendData = [];
            var seriesData = [];
            var selected = {};
            for (var i = 0; i < 50; i++) {
                name = Math.random() > 0.65
                    ? makeWord(4, 1) + '·' + makeWord(3, 0)
                    : makeWord(2, 1);
                legendData.push(name);
                seriesData.push({
                    name: name,
                    value: Math.round(Math.random() * 100000)
                });
                selected[name] = i < 6;
            }

            return {
                legendData: legendData,
                seriesData: seriesData,
                selected: selected
            };

            function makeWord(max, min) {
                var nameLen = Math.ceil(Math.random() * max + min);
                var name = [];
                for (var i = 0; i < nameLen; i++) {
                    name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
                }
                return name.join('');
            }
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });

</script>
<script type="text/javascript">

    $(document).ready(function() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main2'));
        function genData(len, offset) {
            var lngRange = [-10.781327, 131.48];
            var latRange = [18.252847, 52.33];

            var arr = new Float32Array(len * 2);
            var off = 0;

            for (var i = 0; i < len; i++) {
                var x = +Math.random() * 10;
                var y = +Math.sin(x) - x * (len % 2 ? 0.1 : -0.1) * Math.random() + (offset || 0) / 10;
                arr[off++] = x;
                arr[off++] = y;
            }
            return arr;
        }

        var data1 = genData(5e5);
        var data2 = genData(5e5, 10);

        option = {
            tooltip: {},
            toolbox: {
                left: 'center',
                feature: {
                    dataZoom: {}
                }
            },
            legend: {
                orient: 'vertical',
                right: 10
            },
            xAxis: [{
            }],
            yAxis: [{
            }],
            dataZoom: [{
                type: 'inside'
            }, {
                type: 'slider'
            }],
            animation: false,
            series : [{
                name: 'A',
                type: 'scatter',
                data: data1,
                dimensions: ['x', 'y'],
                symbolSize: 3,
                itemStyle: {
                    opacity: 0.4
                },
                large: true
            }, {
                name: 'B',
                type: 'scatter',
                data: data2,
                dimensions: ['x', 'y'],
                symbolSize: 3,
                itemStyle: {
                    opacity: 0.4
                },
                large: true
            }]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });

</script>

<script type="text/javascript">

    $(document).ready(function() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main4'));

        // 指定图表的配置项和数据

        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data:['新订单数','试听数量','成单数量','错误订单数量','跳票数量']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'新订单数',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'试听数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'成单数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'错误订单数量',
                    type:'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'跳票数量',
                    type:'line',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    areaStyle: {normal: {}},
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });

</script>

</body>+
</html>