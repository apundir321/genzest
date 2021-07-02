<!-- <html> -->
<!-- <head></head> -->
<!-- <body> -->
<!--    <h1>Login</h1> -->
<!--    <form name='f' action="login" method='POST'> -->
<!--       <table> -->
<!--          <tr> -->
<!--             <td>User:</td> -->
<!--             <td><input type='text' name='username' value=''></td> -->
<!--          </tr> -->
<!--          <tr> -->
<!--             <td>Password:</td> -->
<!--             <td><input type='password' name='password' /></td> -->
<!--          </tr> -->
<!--          <tr> -->
<!--             <td><input name="submit" type="submit" value="submit" /></td> -->
<!--          </tr> -->
<!--       </table> -->
<!--   </form> -->
<!-- </body> -->
<!-- </html> -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="assets/login.css" rel="stylesheet">
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        h2{
            font-size: 1.5rem;
        }
        .wrapper button{
            margin-top: 1.5rem;
            width: 5rem;
            padding: .7rem;
        }
        .wrapper button a{
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
        .wrapper{
            background-color: #212130;
        }
        
    </style>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->
          <!-- <h2 class="active"> Sign In </h2> -->
          <h2 class="inactive underlineHover">Sign In </h2>
    
          <!-- Login Form -->
          <form name='f' action="login" method='POST'>
            <input type="text" id="login" class="fadeIn second shadow" name="username" placeholder="Username">
            <input type="password" id="password" class="fadeIn third shadow" name="password" placeholder="password">
            <!-- <a href="index.html"><input type="submit" value="Log In"></a> -->
            <button type="submit" class="btn btn-dark">Login</button>
          </form>
      
          <!-- Remind Passowrd -->
          <div id="formFooter">
<!--             <a class="underlineHover" href="signup.html">Forgot Password?</a>&nbsp;&nbsp;&nbsp; -->
            <a class="underlineHover" href="signup.html">SignUp</a>
          </div>
      
        </div>
      </div>
</body>
</html>


