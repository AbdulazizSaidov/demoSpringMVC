<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/css/my.css">
    <link rel="stylesheet" type="text/css" href="resources/Table_Fixed_Column/css/main.css">

</head>
<body>


    <div class="div">
        <form name="user" action="/addUser" method="post">
            <p>Ism</p>
            <input class="textbox-select" title="Name" type="text" name="name">
            <p>Familya</p>
            <input class="textbox-select" title="Last Name" type="text" name="lastName">
            <p>Sharif</p>
            <input class="textbox-select" title="Middle Name" type="text" name="middleName">
            <p>Tug'ilgan sana</p>
            <input class="textbox-select" title="Year Of Birth" type="date" name="yearOfBirth">
            <p>Millat</p>
            <input class="textbox-select" title="Nationality" type="text" name="nationality">
            <p>Ma'lumot</p>
            <select id="education" name="education" class="textbox-select">
                <option value="higher">Higher</option>
                <option value="secondary">Secondary</option>
            </select>
            <p>O'qigan joy</p>
            <input class="textbox-select"  title="Place Of Study" type="text" name="placeOfStudy">
            <p>Tugatgan yil</p>
            <input class="textbox-select" title="Year of Completion" type="date" name="yearOfCompletion">
            <p>Telefon raqam</p>
            <input class="textbox-select" maxlength="17" type="tel"
                   name="phone">
            <p>Email</p>
            <input class="textbox-select" type="email" name="email">
            <input class="submit" type="submit" value="OK">
        </form>
    </div>


</body>
</html>