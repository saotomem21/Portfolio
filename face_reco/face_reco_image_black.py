import face_recognition
from PIL import Image, ImageDraw

# 画像を読み込む
load_image = face_recognition.load_image_file("images/IMG_3783.JPG")

# 認識させたい画像から顔検出する
face_locations = face_recognition.face_locations(load_image)

pil_image = Image.fromarray(load_image)
draw = ImageDraw.Draw(pil_image)

# 画像全体を黒で塗りつぶす
draw.rectangle(((0, 0), pil_image.size), fill="black")

# 検出した顔分ループする
for (top, right, bottom, left) in face_locations:
    # 顔部分を元の画像で塗りつぶす
    face_image = load_image[top:bottom, left:right]
    pil_image.paste(Image.fromarray(face_image), (left, top))

# 結果の画像を表示する
pil_image.show()
