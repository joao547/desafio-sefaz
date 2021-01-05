<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <script src="http://code.jquery.com/jquery-latest.js">
    </script>
    <script>
        $(document).ready(function() {
            $('#submit').click(function(event) {
                var email=$('#email').val();
                var senha=$('#senha').val();
                $.post('/api/usuarios/login',{email:email, senha: senha})
                    .done(function (data) {
                        console.log('data: ', data);
                    });
            });
        });
    </script>
</head>
<body>
    <form>
        <label for="email">Email</label>
        <input type="email" name="email" id="email">
        <label for="senha">Email</label>
        <input type="password" name="senha" id="senha">
        <input type="submit" value="Login" id="submit">
    </form>
</body>
</html>
