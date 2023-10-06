function displayImage(event) {
    var uploadedImage = document.getElementById('uploadedImage');
    uploadedImage.src = URL.createObjectURL(event.target.files[0]);
    uploadedImage.style.display = 'block';
}
