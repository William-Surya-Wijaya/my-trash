import os
from moviepy.config import change_settings
from moviepy.editor import VideoFileClip, TextClip, CompositeVideoClip, AudioFileClip

change_settings({"IMAGEMAGICK_BINARY": "C:\\Program Files\\ImageMagick-7.1.1-Q16-HDRI\\magick.exe"})

def generate_word_clips(sentence1, sentence2, start_time, duration, font_path, font_size=56, color='white', position1=('center', 'center'), y_offset=50):
    word_clips = []
    word_duration = duration / len(sentence2.split())

    sentence1_clip = (TextClip(sentence1, fontsize=72, font=font_path, color=color)
        .set_position(position1)
        .set_start(start_time)
        .set_duration(duration)
        .crossfadein(word_duration / 2))
    word_clips.append(sentence1_clip)

    video_height = 1080
    center_y = video_height // 2
    english_y_position = center_y + y_offset

    bold_clip = TextClip(sentence2.strip(), fontsize=font_size, font=font_path, color=color)
    bold_clip = bold_clip.set_position(('center', english_y_position)).set_start(start_time).set_duration(duration).crossfadein(word_duration / 2)
    word_clips.append(bold_clip)

    return word_clips

def generate_lyric_clip(lyrics, font_path, font_size=50, color='white'):
    clips = []
    for (text1, text2, start, end) in lyrics:
        duration = end - start
        word_clips = generate_word_clips(text1, text2, start, duration, font_path, font_size, color)
        clips.extend(word_clips)
    return clips

def main():
    video = VideoFileClip('bg_4.mp4')
    audio = AudioFileClip('yuika17.mp3')

    lyrics = [
        ("拝啓、過去のわたしへ", "Untuk diriku dimasa lalu", 0.5, 3),
        ("今のわたしは", "Diriku sekarang", 3, 6.5),
        ("ずっと夢見ていたこと叶えてるよ", "Sedang mengejar mimpi yang ada sejak dulu", 6.5, 12),
        ("拝啓、今のわたしへ", "Untuk diriku dimasa depan", 12, 15),
        ("こんな情けない", "Lagu yang menyedihkan ini", 15, 18),
        ("歌だって歌えばいいよ", "Bisa dinyanyikan", 18, 21),
        ("それがわたしだから", "Karena aku yang menyanyikan", 21, 24),
        ("拝啓、未来のわたしへ", "Untuk diriku dimasa depan", 25, 27.5),
        ("今そこは", "Sekarang", 27.5, 30.5),
        ("どんなきれいな世界が", "Dunia yang indah ini", 30.5, 33),
        ("広がっていますか", "Sedang membentang", 33, 36.5),
        ("拝啓、今のわたしへ", "Untuk diriku dimasa depan", 36.5, 39.5),
        ("今ここが", "Sekarang", 39.5, 42.5),
        ("どんな世界よりも", "Di sini", 42.5,45.5),
        ("幸せでした", "Ku bahagia", 45.5, 51.5),
        ("『ユイカ』", "17さいのうた。", 53.5, 56.5),
        
    ]

    font_path = "fonts/NotoSansJP-Regular.ttf"

    lyric_clips = generate_lyric_clip(lyrics, font_path)

    final = CompositeVideoClip([video, *lyric_clips])
    final = final.set_audio(audio)

    final.write_videofile('output_video_4.mp4', codec='libx264', fps=30)

if __name__ == "__main__":
    main()