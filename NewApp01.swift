import SwiftUI

// Documentation:
// This SwiftUI component displays a user interface where users can either take a new photo or upload an existing image.
// Upon selecting an option, the chosen image is displayed in the center of the screen, fitting within the screen's bounds.
// The two buttons, "Take Photo" and "Upload Image," slide to the top of the screen.

struct ContentView: View {
    // State variables to manage image selection and presentation
    @State private var selectedImage: UIImage?
    @State private var isImagePickerDisplayed = false
    @State private var sourceType: UIImagePickerController.SourceType = .photoLibrary
    
  // 1. Define the body of the ContentView
    var body: some View {
        // 1.1. Use a ZStack to layer the image and buttons
        ZStack {
            // 1.2. Display the selected image
            if let selectedImage = selectedImage {
                Image(uiImage: selectedImage)
                    .resizable()
                    .scaledToFit()
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .edgesIgnoringSafeArea(.all)
            }
            // 1.3. Slide the buttons to the top of the screen
            VStack {
                // 1.3.1. Create a "Take Photo" button
                Button(action: {
                    // 1.3.1.1. Set the action to take a photo
                    self.sourceType = .camera
                    self.isImagePickerDisplayed = true
                }) {
                    // 1.3.1.2. Set the button's label with an icon and text
                    Label("写真を撮る", systemImage: "camera")
                }
                .buttonStyle(.borderedProminent) // Use the bordered prominent button style
                .padding() // Add padding around the button
                
                // 1.3.2. Create an "Upload Image" button
                Button(action: {
                    // 1.3.2.1. Set the action to upload an image
                    self.sourceType = .photoLibrary
                    self.isImagePickerDisplayed = true
                }) {
                    // 1.3.2.2. Set the button's label with an icon and text
                    Label("画像をアップロード", systemImage: "photo.on.rectangle")
                }
                .buttonStyle(.bordered) // Use the bordered button style
                .padding() // Add padding around the button
                
                Spacer() // Push the buttons to the top
            }
            .sheet(isPresented: $isImagePickerDisplayed) {
                // 1.4. Present the image picker when needed
                ImagePicker(selectedImage: $selectedImage, sourceType: sourceType)
            }
        }
    }
}

// 2. Define an ImagePicker component to interface with UIKit's UIImagePickerController
struct ImagePicker: UIViewControllerRepresentable {
    @Binding var selectedImage: UIImage?
    var sourceType: UIImagePickerController.SourceType
    
    // 2.1. Make the UIViewController
    func makeUIViewController(context: Context) -> UIImagePickerController {
        let picker = UIImagePickerController()
        picker.delegate = context.coordinator
        picker.sourceType = sourceType
        return picker
    }
    
    // 2.2. Update the UIViewController
    func updateUIViewController(_ uiViewController: UIImagePickerController, context: Context) {
        // No update action needed
    }
    
    // 2.3. Make a Coordinator to handle the image picker delegate methods
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    // 2.4. Define the Coordinator class
    class Coordinator: NSObject, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
        var parent: ImagePicker
        
        init(_ parent: ImagePicker) {
            self.parent = parent
        }
        
        // 2.4.1. Handle the image picker's didFinishPickingMediaWithInfo delegate method
        func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
            if let image = info[.originalImage] as? UIImage {
                parent.selectedImage = image
            }
            picker.dismiss(animated: true)
        }
        
        // 2.4.2. Handle the image picker's didCancel delegate method
        func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
            picker.dismiss(animated: true)
        }
    }
}

// Preview provider for the ContentView
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}