import face_recognition
from PIL import Image, ImageDraw, ImageOps

# Load the image
load_image = face_recognition.load_image_file("images/IMG_3783.JPG")

# Detect faces in the image
face_locations = face_recognition.face_locations(load_image)

pil_image = Image.fromarray(load_image)
draw = ImageDraw.Draw(pil_image)

# Paint the image black
draw.rectangle(((0, 0), pil_image.size), fill="black")

# Loop over each face found in the image
for (top, right, bottom, left) in face_locations:
    # Extract the face from the original image
    face_image = pil_image.crop((left, top, right, bottom))

    # Create a new image with the same size as the face, filled with black
    mask_image = Image.new('L', face_image.size, "black")

    # Draw a white circle on the mask image
    mask_draw = ImageDraw.Draw(mask_image)
    mask_draw.ellipse([(0, 0), mask_image.size], fill="white")

    # Apply the mask to the face image
    face_image_with_mask = Image.composite(face_image, ImageOps.colorize(mask_image, 'black', 'white'), mask_image)

    # Paste the face image back onto the original image
    pil_image.paste(face_image_with_mask, (left, top))

# Show the result
pil_image.show()
