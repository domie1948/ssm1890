<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑学生选课</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">学生选课管理</li>
                        <li class="breadcrumb-item active">编辑学生选课</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">学生选课信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>选课</label>
                                        <div>
                                            <select id="xuankeSelect" name="xuankeSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>课程名称</label>
                                        <input id="kechengId" name="kechengId" class="form-control"
                                               placeholder="课程名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>学科</label>
                                        <input id="kemuValue" name="kemuValue" class="form-control"
                                               placeholder="学科" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>教师名称</label>
                                        <input id="jiaoshiIda" name="jiaoshiIda" class="form-control"
                                               placeholder="教师名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>课程性质</label>
                                        <input id="xingzhiValue" name="xingzhiValue" class="form-control"
                                               placeholder="课程性质" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>上课时间</label>
                                        <input id="shijian" name="shijian" class="form-control"
                                               placeholder="上课时间" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>上课地点</label>
                                        <input id="didian" name="didian" class="form-control"
                                               placeholder="上课地点" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>学分</label>
                                        <input id="xuefen" name="xuefen" class="form-control"
                                               placeholder="学分" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>周学时</label>
                                        <input id="zhouxueshi" name="zhouxueshi" class="form-control"
                                               placeholder="周学时" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>容量</label>
                                        <input id="rongliang" name="rongliang" class="form-control"
                                               placeholder="容量" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>已选</label>
                                        <input id="yixuan" name="yixuan" class="form-control"
                                               placeholder="已选" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>余量</label>
                                        <input id="yuliang" name="yuliang" class="form-control"
                                               placeholder="余量" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="xuankeId" name="xuankeId" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="jiaoshiId" name="jiaoshiId" type="hidden">
                                       <input value="0" type="hidden" id="shifouTypesSelect" name="shifouTypes" class="form-control">
                                <div class="form-group col-md-12 mb-3">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "shenqing";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var shifouTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var jiaoshiOptions = [];
    var xuankeOptions = [];
    var yonghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#xuankeId") !=null){
               var xuankeId = $("#xuankeId").val();
               if(xuankeId == null || xuankeId =='' || xuankeId == 'null'){
                   alert("课程名称不能为空");
                   return;
               }
           }
           if($("#yonghuId") !=null){
               var yonghuId = $("#yonghuId").val();
               if(yonghuId == null || yonghuId =='' || yonghuId == 'null'){
                   alert("学生不能为空");
                   return;
               }
           }
           if($("#jiaoshiId") !=null){
               var jiaoshiId = $("#jiaoshiId").val();
               if(jiaoshiId == null || jiaoshiId =='' || jiaoshiId == 'null'){
                   alert("教师不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                successMes = '添加成功';
            }
            httpJson("shenqing/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addshenqing');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function shifouTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shifou_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shifouTypesOptions = res.data.list;
                }
            });
        }

        function jiaoshiSelectOne(id) {
            http("jiaoshi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                jiaoshiShowImg();
                jiaoshiDataBind();
            }
        });
        }
        function xuankeSelect() {
            //填充下拉框选项
            http("xuanke/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    xuankeOptions = res.data.list;
                }
            });
        }

        function xuankeSelectOne(id) {
            http("xuanke/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                xuankeShowImg();
                xuankeDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationShifoutypesSelect(){
            var shifouTypesSelect = document.getElementById('shifouTypesSelect');
            if(shifouTypesSelect != null && shifouTypesOptions != null  && shifouTypesOptions.length > 0 ){
                for (var i = 0; i < shifouTypesOptions.length; i++) {
                    shifouTypesSelect.add(new Option(shifouTypesOptions[i].indexName,shifouTypesOptions[i].codeIndex));
                }
            }
        }

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->

        function initializationxuankeSelect() {
            var xuankeSelect = document.getElementById('xuankeSelect');
            if(xuankeSelect != null && xuankeOptions != null  && xuankeOptions.length > 0 ) {
                for (var i = 0; i < xuankeOptions.length; i++) {
                        xuankeSelect.add(new Option(xuankeOptions[i].name, xuankeOptions[i].id));
                }

                $("#xuankeSelect").change(function(e) {
                        xuankeSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].name, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var shifouTypesSelect = document.getElementById("shifouTypesSelect");
        if(shifouTypesSelect != null && shifouTypesOptions != null  && shifouTypesOptions.length > 0 ) {
            for (var i = 0; i < shifouTypesOptions.length; i++) {
                if (shifouTypesOptions[i].codeIndex == ruleForm.shifouTypes) {//下拉框value对比,如果一致就赋值汉字
                        shifouTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var xuankeSelect = document.getElementById("xuankeSelect");
            if(xuankeSelect != null && xuankeOptions != null  && xuankeOptions.length > 0 ) {
                for (var i = 0; i < xuankeOptions.length; i++) {
                    if (xuankeOptions[i].id == ruleForm.xuankeId) {//下拉框value对比,如果一致就赋值汉字
                        xuankeSelect.options[i+1].selected = true;
                        $("#xuankeSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addshenqing');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                xuankeId: "required",
                yonghuId: "required",
                jiaoshiId: "required",
                shifouTypes: "required",
            },
            messages: {
                xuankeId: "课程名称不能为空",
                yonghuId: "学生不能为空",
                jiaoshiId: "教师不能为空",
                shifouTypes: "是否同意不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addshenqing = window.sessionStorage.getItem("addshenqing");
        if (addshenqing != null && addshenqing != "" && addshenqing != "null") {
            window.sessionStorage.removeItem('addshenqing');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("shenqing/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        jiaoshiDataBind();
        xuankeDataBind();
        yonghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#xuankeId").val(ruleForm.xuankeId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#jiaoshiId").val(ruleForm.jiaoshiId);

    }
    <!--  级联表的数据回显  -->
    function jiaoshiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#jiaoshiId").val(ruleForm.id);

        $("#jsname").val(ruleForm.jsname);
        $("#jsusername").val(ruleForm.jsusername);
        $("#jspassword").val(ruleForm.jspassword);
        $("#jssexValue").val(ruleForm.jssexValue);
        $("#jsphone").val(ruleForm.jsphone);
        $("#jsidNumber").val(ruleForm.jsidNumber);
        $("#jsrole").val(ruleForm.jsrole);
    }

    function xuankeDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#xuankeId").val(ruleForm.id);

        $("#kechengId").val(ruleForm.kechengId);
        $("#kemuValue").val(ruleForm.kemuValue);
        $("#jiaoshiIda").val(ruleForm.jiaoshiId);
        $("#xingzhiValue").val(ruleForm.xingzhiValue);
        $("#shijian").val(ruleForm.shijian);
        $("#didian").val(ruleForm.didian);
        $("#xuefen").val(ruleForm.xuefen);
        $("#zhouxueshi").val(ruleForm.zhouxueshi);
        $("#rongliang").val(ruleForm.rongliang);
        $("#yixuan").val(ruleForm.yixuan);
        $("#yuliang").val(ruleForm.yuliang);
        $("#beizhuContent").val(ruleForm.beizhuContent);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#name").val(ruleForm.name);
        $("#username").val(ruleForm.username);
        $("#password").val(ruleForm.password);
        $("#sexValue").val(ruleForm.sexValue);
        $("#phone").val(ruleForm.phone);
        $("#idNumber").val(ruleForm.idNumber);
        $("#role").val(ruleForm.role);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        jiaoshiShowImg();
        xuankeShowImg();
        yonghuShowImg();
    }


    <!--  级联表的图片  -->

    function jiaoshiShowImg() {
        $("#jsimgPhotoImg").attr("src",ruleForm.jsimgPhoto);
    }


    function xuankeShowImg() {
    }


    function yonghuShowImg() {
        $("#imgPhotoImg").attr("src",ruleForm.imgPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            shifouTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            xuankeSelect();
            yonghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationShifoutypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationjiaoshiSelect();
            initializationxuankeSelect();
            initializationyonghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>