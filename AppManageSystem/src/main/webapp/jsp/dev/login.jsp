
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开发者登录</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <style>
        form{
            width: 300px;
            margin: auto;
            margin-top: 10%;
        }
    </style>
</head>
<body>
${errorMsg}
<div class="layui-container">
    <FORM ACTION="${ctx}/dev/login" method="post">
        <div class="layui-form-item">
            <%--<label class="layui-form-label">用户名</label>--%>
            <div class="layui-input-inline">
                <input type="text" name="devCode" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <%--<label class="layui-form-label">密码</label>--%>
            <div class="layui-input-inline">
                <input type="password" name="devPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                <button type="reset" class="layui-btn layui-btn-primary">重填</button>
            </div>
        </div>
    </FORM>
</div>



<%--js--%>
<script src="${ctx}/static/plugins/layui/layui.js"></script>

</body>
</html>
