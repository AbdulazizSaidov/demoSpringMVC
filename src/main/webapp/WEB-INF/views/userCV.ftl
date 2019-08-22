<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<head>

    <title>Info</title>
    <style>
        th, td{
            text-align: left;

            padding: 20px;
        }
        input[type=submit]{
            width: 10%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
    </style>
</head>
<body>

<h1 align=center>${user.name} ${user.lastName} ${user.middleName} haqida ma'lumot</h1>
<table>
    <tr>
        <th>
            Id
        </th>
        <th >
            Ism
        </th>
        <th>
            Familya
        </th >
        <th>
            Sharif
        </th>
        <th>
            Tug'ilgan sana
        </th>
        <th>
            Millati
        </th>
        <th>
            Ma'lumoti
        </th>
        <th>
            Bitirgan o'quv maskanlari
        </th>
        <th>
            Telefon raqam
        </th>
        <th>
            Email
        </th>

    </tr>
    <tr>
        <td>
        ${user.id}
        </td>
        <td>
        ${user.name}
        </td>
        <td>
        ${user.lastName}
        </td >
        <td>
        ${user.middleName}
        </td>
        <td>
        ${user.birth}
        </td>
        <td>
        ${user.nationality}
        </td>
        <td>
        ${user.education}
        </td>
        <td>
        ${user.placeOfStudy}
        </td>
        <td>
        ${user.phone}
        </td>
        <td>
        ${user.email}
        </td>
    </tr>
    <tr>
        <td>
            <a href="/toPdf/${user.id}">Export to PDF</a>
        </td>
    </tr>
</table>
</body>
</html>