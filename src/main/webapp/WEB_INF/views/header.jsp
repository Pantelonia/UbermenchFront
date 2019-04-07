<style>
    * {
        padding: 0;
        margin: 0;
    }
    a:visited {
        color: black;
    }
    a {
        color: black;
        text-decoration: none;
    }
    .header {
        height: 100px;
        border: 1px solid darkgray;
        background-color: antiquewhite;
    }
    .icon {
        width: fit-content;
        margin: 30px;
    }
    .searchInput {
        margin: 30px;
    }
    .inline-block {
        display: inline-block;
    }
    .login {
        margin: 0 20px;
    }
    .register {
        margin: 0 20px;
    }
    .authotisation-block {
        float: right;
        margin: 40px;
    }
</style>
<div class = "header">
    <div class="icon inline-block">
        <h1><a href="/">MusicOn</a></h1>
    </div>
    <div class="searchInput inline-block">
        <form method="post" action="/search">
            <input type="text" name="title"/>
            <input type="submit" value="Find"/>
        </form>
    </div>
    <div class="authotisation-block inline-block">
        <div class="login inline-block">
            <a href="/login">Login</a>
        </div>
        <div class="register inline-block">
            <a href="/register">Register</a>
        </div>
    </div>
</div>