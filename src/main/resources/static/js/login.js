$(function(){
    code();
});

//获取验证码
function code(){
    console.log("sdf");/*
    $.ajax({
        type:"get",
        url:  "code",
        // dataType:"JPEG",
        async:false,
        success: function(e){
            console.log(e);
            $("#code").attr("src","data:image/gif;base64,"+e);
        },
        error: function(e){console.log(e)}
    });*/
    var xmlHttp;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET","http://localhost:8080/code",true);
    xmlHttp.responseType = "blob";
    xmlHttp.onload = function () {
        console.log(this);
        if (this.status = 200){
            var blob = this.response;
            var img = document.createElement("img");
            img.onload = function (ev) {
                window.URL.revokeObjectURL(img.src);
            };
            img.src = window.URL.createObjectURL(blob);
            document.body.appendChild(img);
        }
    }
    xmlHttp.send();
}