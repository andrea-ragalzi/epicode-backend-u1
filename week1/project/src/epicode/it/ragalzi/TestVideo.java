package src.epicode.it.ragalzi;

public class TestVideo {
    public static void main(String[] args) {
        Video video = new Video("Titanic", 8, 5, 7);
        System.out.println(video);
        video.play();
        for (int i = 0; i < 100; i++) {
            video.alzaLuminosita();
        }
        System.out.println(video);
        video.play();
        for (int i = 0; i < 100; i++) {
            video.abbassaLuminosita();
        }
        System.out.println(video);
        video.play();
        for (int i = 0; i < 15; i++) {
            video.alzaVolume();
        }
        System.out.println(video);
        video.play();
        System.out.println(video);
        video.play();
        for (int i = 0; i < 15; i++) {
            video.abbassaVolume();
        }
        System.out.println(video);
        video.play();
    }
}
