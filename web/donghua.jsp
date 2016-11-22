
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Example</title>
    <script src="10.17.js"></script>
    <link rel="script" href="js/10.17.js">
</head>
<body>
<!--<p id="example" style="color: bisque;font-family: 'Arial',sans-serif;">-->
<!--An example of a paragraph-->
<!--</p>-->
<p id="message">Whee!1111</p>
<input id="btn" value="move" onclick="moveMessage()"/>
<script>
    window.onload = function(){
        var para = document.getElementById("example");
        para.style.font = "2em 'Times',serif";
    };
    function positionMessage(){
        var elem = get("#message");
        if(!elem) return false;
        elem.style.position = "absolute";
        elem.style.left = "50px";
        elem.style.top = "100px";
    }
    function moveMessage(){
        var elem = get("message");
        if(!elem) return false;
        var x = elem.style.left;
        var pos_x = parseInt(x);
        pos_x += 10;
        elem.style.left = pos_x + "px";
        setTimeout("moveMessage()",50);
    }

    window.onload = positionMessage;
    AddLoadEvent(positionMessage);
    AddLoadEvent(moveMessage);
</script>
</body>
</html>