<!DOCTYPE html>
<html lang="en">
<head>
    <title>Table V05</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="resources/Table_Fixed_Column/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/css/util.css">
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/css/main.css">
    <!--===============================================================================================-->


</head>
<body>

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1">
                <div class="table100-firstcol">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column1">Id</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list users as user>
                        <tr class="row100 body">
                            <td class="cell100 column1"><a href="/cv?id=${user.id}">${user.id}</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="wrap-table100-nextcols js-pscroll">
                    <div class="table100-nextcols">
                        <table>
                            <thead>
                            <tr class="row100 head">
                                <th class="cell100 column2">Name</th>
                                <th class="cell100 column3">Email</th>
                                <th class="cell100 column4">Last Name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list users as user>
                            <tr class="row100 body">
                                <td class="cell100 column2">${user.name}</td>
                                <td class="cell100 column3">${user.email}</td>
                                <td class="cell100 column4">${user.lastName}</td>
                                <td class="cell100 column4"> <a href="/delete/${user.id}">Delete</a> </td>
                                <td class="cell100 column4"> <a href="/update/${user.id}">Update</a> </td>
                                <td class="cell100 column4"> <a href="/addUser">Add</a> </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--===============================================================================================-->
<script src="resources/Table_Fixed_Column/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="resources/Table_Fixed_Column/vendor/bootstrap/js/popper.js"></script>
<script src="resources/Table_Fixed_Column/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="resources/Table_Fixed_Column/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="resources/Table_Fixed_Column/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function(){
        var ps = new PerfectScrollbar(this);

        $(window).on('resize', function(){
            ps.update();
        })

        $(this).on('ps-x-reach-start', function(){
            $(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
        });

        $(this).on('ps-scroll-x', function(){
            $(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
        });

    });

</script>
<!--===============================================================================================-->
<script src="resources/Table_Fixed_Column/js/main.js"></script>


<#--<h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
    <#list users as user>
        <tr>
            <td><a href="/cv?id=${user.id}">${user.id}</a></td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>-->

</body>
</html>