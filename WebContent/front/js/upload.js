function subform() {

    if($("#imgfield").html()){
        //获取裁剪完后的base64图片url,转换为blob
        var data=document.getElementById("myCan").toDataURL();
        var formData=new FormData();
        formData.append("imageName",dataURLtoBlob(data));


        var httprequest=new XMLHttpRequest();
        var apiurl=""; //上传图片的api接口，自行填写
        httprequest.open('POST',apiurl,true);
        httprequest.send(formData);
        httprequest.onreadystatechange= function () {
            if(httprequest.status==200 && httprequest.readyState==4){

                var json=JSON.parse(httprequest.responseText);
                console.log(json)
            }else{
                alert("上传图片失败！api错误")
            }
        };


    }else{

        alert("请选择图片!")
    }


}


function getimg() {

    $("#fileimg").click();

}
function imgchange() {

    var localimg = $("#fileimg").get(0).files[0];

    if(!localimg){
        return;
    }

    var fileName = localimg.name;
    var fileSize = localimg.size;
    var fileType=fileName.substring(fileName.lastIndexOf('.'),fileName.length).toLowerCase();
    if(fileType!='.gif' && fileType!='.jpeg' && fileType!='.png' && fileType!='.jpg')
    {
        alert("上传失败，请上传jpg,png格式的图片");
        return;
    }

    var size=3*1024*1024;
    if(fileSize>size){
        alert("上传失败，请上传3MB以内的图片。");
        return;
    }

    var reader=new FileReader();
    //将文件读取为DataURL
    reader.readAsDataURL(localimg);
    reader.onload= function (e) {
        var localimghtml = '<img id="cropbox" src="' +  e.target.result + '" >';
        $("#imgfield").html(localimghtml);
        initJcrop();
    };

}


function initJcrop(){
    $('#cropbox').Jcrop({
        onSelect: updateCoords,
        aspectRatio: 1,
        boxWidth: 300,
        boxHeight: 300
    }, function () {

        //图片实际尺寸
        var bb = this.getBounds();
        var bWidth= Number(bb[0]) / 2;
        var bHeight= Number(bb[1]) / 2;

        this.setSelect([0, 0, bWidth,bHeight]);


        var ss = this.getWidgetSize();
        var aheight = (300 - Number(ss[1])) / 2 + "px";
        $(".jcrop-holder").css("margin-top", aheight);


    });
}
function updateCoords(c){
//      console.log(c);
    var img=document.getElementById("cropbox");
    var ctx=document.getElementById("myCan").getContext("2d");

    //img,开始剪切的x,Y坐标宽高，放置图像的x,y坐标宽高。
    ctx.drawImage(img,c.x,c.y, c.w, c.h,0,0,200,200);
}



//**dataURL to blob**
function dataURLtoBlob(dataurl) {
    var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }
    return new Blob([u8arr], { type: mime });
}