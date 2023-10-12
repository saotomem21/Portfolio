var originalImageData = null;

function displayImage(event) {
    var canvas = document.getElementById('canvas');
    var ctx = canvas.getContext('2d');
    var img = new Image();
    img.src = URL.createObjectURL(event.target.files[0]);
    img.onload = function() {
        var displayWidth = window.innerWidth * 0.5; // 画面の半分の幅
        var displayHeight = img.height * (displayWidth / img.width); // アスペクト比を保持
        canvas.style.display = 'block';
        canvas.width = displayWidth;
        canvas.height = displayHeight;
        ctx.drawImage(img, 0, 0, displayWidth, displayHeight);
        originalImageData = ctx.getImageData(0, 0, canvas.width, canvas.height); // 画像データを保存
    }
}

function makeBlack() {
    var btn = document.querySelector('.msr_btn13');
    btn.classList.add('clicked');
    var canvas = document.getElementById('canvas');
    var ctx = canvas.getContext('2d');
    var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
    var data = imageData.data;
    for (var i = 0; i < data.length; i += 4) {
        var grayscale = data[i] * 0.3 + data[i + 1] * 0.59 + data[i + 2] * 0.11;
        data[i] = grayscale;
        data[i + 1] = grayscale;
        data[i + 2] = grayscale;
    }
    ctx.putImageData(imageData, 0, 0);

    // setTimeout関数を使用して、クリック後0.3秒後にボタンのスタイルを元に戻します。
    setTimeout(function() {
        btn.classList.remove('clicked');
    }, 300);
}


function restoreImage() {
    if (originalImageData) {
        var canvas = document.getElementById('canvas');
        var ctx = canvas.getContext('2d');
        ctx.putImageData(originalImageData, 0, 0);  // 元の画像データを復元
    }
}

function downloadImage() {
    var canvas = document.getElementById('canvas');
    var imageURI = canvas.toDataURL("image/jpeg");
    var link = document.createElement('a');
    link.href = imageURI;
    link.download = 'edited-image.jpeg';
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
