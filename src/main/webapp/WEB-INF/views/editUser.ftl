<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    

    <style>
        input[type=text], select{
            width: 30%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=date]{
            width: 30%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=email]{
            width: 30%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
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
        }
        input[type=tel]{
            width: 30%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        div{
            border-radius: 5px;
            background-color: #868e96;
            padding: 20px; 
        }
        

    </style>

</head>

<body>
 <div >
    <form name="user" action="/editUser" method="post">
        <p>Id</p>
        <input title="Id" type="text" name="id" value="${user.id}">
        <p>Ism</p>
        <input  title="Name" type="text" name="name" value="${user.name}">
        <p>Familya</p>
        <input  title="Last Name" type="text" name="lastName" value="${user.lastName}">
        <p>Sharif</p>
        <input  title="Middle Name" type="text" name="middleName" value="${user.middleName}">
        <p>Tug'ilgan sana</p>
        <input  title="Year Of Birth" type="date" name="yearOfBirth" value="${user.yearOfBirth}">
        <p>Millat</p>
        <input  title="Nationality" type="text" name="nationality" value="${user.nationality}">
        <p>Ma'lumot</p>
        <select id="education" name="education" >
            <option value="${user.education}">${user.education}</option>
            <option value="${user.education}">${user.education}</option>
        </select>
        <p>O'qigan joy</p>
        <input   title="Place Of Study" type="text" name="placeOfStudy" value="${user.placeOfStudy}">
        <p>Tugatgan yil</p>
        <input title="Year of Completion" type="date" name="yearOfCompletion" value="${user.yearOfCompletion}">
         <p>Telefon raqam</p>
            <input  maxlength="17" type="tel" name="phone" value="${user.phone}">
        <p>Email</p>
        <input type="email" name="email" value="${user.email}">
        <input type="submit" value="OK">
    </form>
</div>

</body>
</html>