<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--<div class="layui-header">
        <div class="layui-logo">APP BMS</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        &lt;%&ndash;<ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>&ndash;%&gt;
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>--%>
    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <form action="${ctx}/app/add" class="layui-form" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">软件名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareName" lay-verify="title" autocomplete="off" placeholder="请输入软件名称" class="layui-input" >
                    </div>
                    <label class="layui-form-label">APK名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="apkName" lay-verify="title" autocomplete="off" placeholder="请输入APK名称" class="layui-input" >
                    </div>
                    <label class="layui-form-label">支持ROM</label>
                    <div class="layui-input-inline">
                        <input type="text" name="supportROM" lay-verify="title" autocomplete="off" placeholder="请输入ROM名称" class="layui-input" >
                    </div>
                    <label class="layui-form-label">界面语言</label>
                    <div class="layui-input-inline">
                        <input type="text" name="interfaceLanguage" lay-verify="title" autocomplete="off" placeholder="请输入界面语言" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">软件大小</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareSize" lay-verify="title" autocomplete="off" placeholder="请输入软件大小" class="layui-input" >
                    </div>
                    <label class="layui-form-label">APP状态</label>
                    <div class="layui-input-inline">
                        <select name="status" lay-filter="status">
                            <option value="">请选择</option>
                            <c:forEach items="${appStatuses}" var="obj">
                                <option value="${obj.valueId}">${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <label class="layui-form-label">所属平台</label>
                    <div class="layui-input-inline">
                        <select name="flatform.valueId" lay-filter="flatform">
                            <option value="">请选择</option>
                            <c:forEach items="${appFlatforms}" var="obj">
                                <option value="${obj.valueId}">${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="layui-form-label">应用简介</label>
                    <div class="layui-input-inline">
                        <input type="text" name="appInfo" lay-verify="title" autocomplete="off" placeholder="应用简介" class="layui-input" >
                    </div>
                    <%--TODO 一级分类--%>
                    <%--TODO  二级分类--%>
                    <%--TODO  三级分类--%>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select name="categoryLevel1.id" id="levelOne" lay-filter="levelOne">
                            <option value="">请选择</option>
                            <c:forEach items="${levelOne}" var="obj">
                                <option value="${obj.id}">${obj.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select name="categoryLevel2.id" lay-filter="levelTwo" id="levelTwo">
                            <option value="">请选择</option>
                        </select>
                    </div>

                    <label class="layui-form-label">三级分类</label>
                    <div class="layui-input-inline">
                        <select name="categoryLevel3.id" lay-filter="levelThree" id="levelThree">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    </div>

                </div>
            </form>

        </div>
    </div>

    <%--<div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>--%>
    <jsp:include page="/jsp/common/footer.jsp"/>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;
        form.render();

        //一级分类start=================================
        form.on('select(levelOne)',function () {

            var levelOneId = $('#levelOne').val();
            if (levelOneId == ''){
                //选择level2更新
                $('#levelTwo').html(html);
                form.render();
                return;
            } else{
                $.ajax({
                    url:'${ctx}/category/queryLevelTwoByLevelOne/' + levelOneId,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据，重新渲染
                        var html = '<option value="">请选择</option>';
                        var len = data.length;
                        var levelTwo = '${appInfoDTO.levelTwo}';
                        for(var i = 0 ; i < len ; i++){
                            html += '<option value="'+data[i].id+'"';
                            if (data[i].id == levelTwo){
                                html += ' selected ';
                            }
                            html += '>'+data[i].categoryName +'<option>';
                        }
                        //选择level2更新
                        $('#levelTwo').html(html);
                        form.render();

                    }
                })
            }


        });
        //一级分类end=========

        //二级分类start=================================
        form.on('select(levelTwo)',function () {

            var levelTwoId = $('#levelTwo').val();
            if (levelTwoId == ''){
                $('#levelThree').html(html);
                form.render();
                return;
            } else{
                $.ajax({
                    url:'${ctx}/category/queryLevelThreeByLevelTwo/' + levelTwoId,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据，重新渲染
                        var html = '<option value="">请选择</option>';
                        var len = data.length;
                        for(var i = 0 ; i < len ; i++){
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName +'<option>';
                        }
                        //选择level2更新
                        $('#levelThree').html(html);
                        form.render();

                    }
                })
            }


        });
        //二级分类end=============


    });
</script>
</body>





</html>
