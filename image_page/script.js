function displayImage(event) {
    var canvas = document.getElementById('canvas');
    var ctx = canvas.getContext('2d');
    var img = new Image();
    img.src = URL.createObjectURL(event.target.files[0]);
    img.onload = function() {
        var displayWidth = img.width;
        var displayHeight = img.height;
        canvas.style.display = 'block';
        canvas.width = displayWidth;
        canvas.height = displayHeight;
        ctx.drawImage(img, 0, 0, displayWidth, displayHeight);
    }
}

function makeBlack() {
    var canvas = document.getElementById('canvas');
    var ctx = canvas.getContext('2d');
    var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
    var data = imageData.data;
    for (var i = 0; i < data.length; i += 4) {
        var grayscale = data[i] * 0.3 + data[i + 1] * 0.59 + data[i + 2] * 0.11;
        data[i] = grayscale;     // 赤
        data[i + 1] = grayscale; // 緑
        data[i + 2] = grayscale; // 青
    }
    ctx.putImageData(imageData, 0, 0);
}
