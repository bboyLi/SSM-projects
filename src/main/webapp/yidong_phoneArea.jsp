<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="utf-8">
	<title>移动用户服务系统----移动用户</title>
	<meta name="description" content="overview &amp; stats">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- basic styles -->

	<meta name="description" content="overview &amp; stats">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css">
<!--[if IE 7]>
  <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
  <![endif]-->

  <!-- page specific plugin styles -->

  <link rel="stylesheet" href="/assets/css/jquery-ui-1.10.3.custom.min.css">
  <link rel="stylesheet" href="/assets/css/chosen.css">
  <link rel="stylesheet" href="/assets/css/datepicker.css">
  <link rel="stylesheet" href="/assets/css/bootstrap-timepicker.css">
  <link rel="stylesheet" href="/assets/css/daterangepicker.css">
  <link rel="stylesheet" href="/assets/css/colorpicker.css">


  <!-- fonts -->

  <link rel="stylesheet" href="/assets/css/ace-fonts.css">

  <!-- ace styles -->

  <link rel="stylesheet" href="/assets/css/ace.min.css">
  <link rel="stylesheet" href="/assets/css/ace-rtl.min.css">
  <link rel="stylesheet" href="/assets/css/ace-skins.min.css">
  <link rel="stylesheet" href="/assets/css/myCss.css">

<!--[if lte IE 8]>
  <link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
  <![endif]-->

  <!-- inline styles related to this page -->

  <!-- ace settings handler -->

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="/assets/js/html5shiv.js"></script>
<script src="/assets/js/respond.min.js"></script>
<![endif]-->
<script src="/assets/js/ace-extra.min.js"></script>
</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="/module/security/index.html" class="navbar-brand">
					<small>
						<i class="icon-cogs"></i>
						移动用户服务系统----移动用户
					</small>
				</a><!-- /.brand -->
			</div><!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							<img class="nav-user-photo" src="/assets/avatars/avatar2.png" alt="Jason's Photo">
							<span class="user-info">
								<small>欢迎,</small>
								${user.username}
							</span>
							<i class="icon-caret-down"></i>
						</a>
						<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a data-target="#modal_4" data-toggle="modal" href="#"> 
									<i class="icon-user"></i>
									修改个人信息
								</a>
							</li>

							<li class="divider"></li>

							<li>
								<a href="user_loginOut">
									<i class="icon-off"></i>
									退出
								</a>
							</li>
						</ul>
					</li>
				</ul><!-- /.ace-nav -->
			</div><!-- /.navbar-header -->
		</div><!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
				<!-- 菜单导航开始 -->
				<ul class="nav nav-list">
					<li class="open">
						<a href="yidong_area">
							<i class="icon-coffee"></i>
							<span class="menu-text">归属地查询</span>
						</a>
						<a href="yidong_business_list" >
							<i class="icon-coffee"></i>
							<span class="menu-text">热门业务</span>
						</a>
						<a href="yidong_jifen" >
							<i class="icon-coffee"></i>
							<span class="menu-text">积分活动</span>
						</a>
						<a href="yidong_fare" >
							<i class="icon-coffee"></i>
							<span class="menu-text">话费服务</span>
						</a>
						<a href="yidong_flow" >
							<i class="icon-coffee"></i>
							<span class="menu-text">流量管理</span>
						</a>
						<a href="yidong_userInfo">
							<i class="icon-coffee"></i>
							<span class="menu-text">个人资料</span>
						</a>
						<a href="yidong_advise_list" >
							<i class="icon-coffee"></i>
							<span class="menu-text">用户反馈</span>
						</a>
					</li>

				</ul><!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>
				<!-- 菜单导航结束 -->
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>
					<ul class="breadcrumb">
						<li>
							<i class="icon-home home-icon"></i>
							<a href="user?method=listUserGoods">首页</a>
						</li>		
		<!--<li>
			<i class="icon-home home-icon"></i>
			<a href="/module/security/index.html">首页</a>
			</li>
			<li class="active">用户管理</li> -->
		</ul><!-- .breadcrumb -->
	</div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12 version-detail">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<!-- PAGE CONTENT BEGINS -->
					<form class="form-horizontal" role="form" action="yidong_area" method="post" id="info_classify_FormId">
						<div class="col-xs-12">
							<input class="" type="text" name="phone" value="" placeholder="手机号">
							<input  class="btn btn-sm btn-success" type="submit" value="查询">
						</div>
						<div class="col-xs-12">						
							<div class="well">
							</div>
						</div>	
					</form>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
							<div class="table-responsive">
								<form action = "user?method=delGoods" method="post" id="formSubmit">
									<c:if test="${not empty area.telString}">
									<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-row">
											<div class="profile-info-name"> 地区运营商 </div>
											<div class="profile-info-value">
												<span class="editable editable-click" id="username">${area.carrier}</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name"> 地区 </div>
											<div class="profile-info-value">
												<i class="icon-map-marker light-orange bigger-110"></i>
												<span class="editable editable-click" id="country">${area.province}</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name"> 地区运营商 </div>
											<div class="profile-info-value">
												<span class="editable editable-click" id="age">${area.catName}</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name"> 手机号 </div>
											<div class="profile-info-value">
												<span class="editable editable-click" id="signup">${area.telString}</span>
											</div>
										</div>
									</div>
									</c:if>
									<c:if test="${empty area.telString}">
										<h1>你查询的手机号不存在！！！</h1>
									</c:if>
								</form>
							</div>
							<nav>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>
			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; Choose Skin</span>
				</div>
				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
					<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
				</div>
				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
					<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
				</div>
				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
					<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
				</div>
				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
					<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
				</div>
				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
					<label class="lbl" for="ace-settings-add-container">
						Inside
						<b>.container</b>
					</label>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div>

<!-- 弹出层 -->

<div id="modal_3" class="modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="blue bigger">选择数量</h4>
			</div>
			<div class="modal-body overflow-visible">
				<div class="">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal form" action="add_business" method="post" id="goumaiForm" cansumbit="yes">
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly">业务名称:</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="name" maxlength="100" placeholder="名称">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly">业务详情:</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="description" maxlength="100" placeholder="密码" >
										</div>
									</div>
								</div>
							</form>
						</div><!-- /.col -->
					</div><!-- /.row --><!-- /.main-content -->
				</div>
			</div>
			<div class="modal-footer">
				<button id="goumai" class="btn btn-sm btn-success" data-dismiss="modal">
					<i class="icon-plus"></i>确定
				</button>
				<button class="btn btn-sm btn-danger" data-dismiss="modal">
					<i class="icon-remove"></i>取消
				</button>
			</div>
		</div>
	</div>
</div>







<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="/assets/js/jquery.dataTables.min.js"></script>
<script src="/assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script src="/assets/js/date-time/daterangepicker.min.js"></script>
<script src="/assets/js/date-time/moment.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		$('[data-rel=tooltip]').tooltip();
		$('#onlineTime').daterangepicker({
			"ranges": {
				"Today": [
				"2016-06-12T09:12:55.445Z",
				"2016-06-12T09:12:55.446Z"
				],
				"Yesterday": [
				"2016-06-11T09:12:55.446Z",
				"2016-06-11T09:12:55.451Z"
				],
				"Last 7 Days": [
				"2016-06-06T09:12:55.451Z",
				"2016-06-12T09:12:55.451Z"
				],
				"Last 30 Days": [
				"2016-05-14T09:12:55.451Z",
				"2016-06-12T09:12:55.451Z"
				],
				"This Month": [
				"2016-05-31T16:00:00.000Z",
				"2016-06-30T15:59:59.999Z"
				],
				"Last Month": [
				"2016-04-30T16:00:00.000Z",
				"2016-05-31T15:59:59.999Z"
				]
			},
			"linkedCalendars": false,
			"startDate": "06/06/2016",
			"endDate": "06/12/2016"
		}, function(start, end, label) {
			console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
		});
	})
</script>
<script type="text/javascript">
	jQuery(function($) {
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
			
		});
		
		$("#tianjiaMenu").click(function(){
			$("#addMenu").submit();
		})
		
		$("#submit").click(function(){
			$("#formSubmit").submit();
		})
		$("#refuseSubmit").click(function(){
			$("#formSubmit").attr("action","user?method=refuseShop");
			$("#formSubmit").submit();
		})
		$("#del").click(function(){
			var r=confirm("确定要你选择的商品，请慎重！")
			if(r=true){
				alert(r);
				$("#formSubmit").submit();
			}else{
				return false;
			}
		})
		
		$(".buy").click(function(){
			$this = $(this);
			var id = $this.attr("gid");
			var price = $this.attr("price");
		})
		
		
		$("#xiugaiMenu").click(function(){
			$("#updateMenu1").submit();
		})
		$("#goumai").click(function(){
			$("#goumaiForm").submit();
		})
		
		$(".addComment").click(function(){
			$this = $(this);
			var gid = $this.parent().parent().parent().find("input[name=id]").val();
			
			$("#modal_5").find("input[name=gid]").val(gid);
		})
		
		$("#addCommentSubmit").click(function(){
			$("#addComment").submit();
		})
		$(".xianshi").click(function(){
			$this = $(this);
			var flag = $this.attr("flag");
			if(flag == "0"){
				$this.parent("ul").find("li[class=pinglunLi]").hide();
				$this.attr("flag","1");
				$this.find("a").text("显示");
			}else{
				$this.parent("ul").find("li[class=pinglunLi]").show();
				$this.attr("flag","0");	
				$this.find("a").text("隐藏");
			}
		})
	})
</script>

</body>
