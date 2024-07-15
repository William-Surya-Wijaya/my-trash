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
    audio = AudioFileClip('audio_2.mp3')

    lyrics = [
        ("そう願っても無駄だから", "Tidak ada gunanya berharap", 0.5, 5.5),
        ("グッバイ", "Selamat tinggal", 5.5, 6.5),
        ("君の運命のヒトは僕じゃない", "Aku bukan orang yang kau impikan", 6.5, 11),
        ("辛いけど否めない", "Menyakitkan tapi tak bisa kusangkal", 11, 14),
        ("でも離れ難いのさ", "Tapi sulit juga untuk meninggalkan", 14, 17),
        ("その髪に触れただけで 痛いや", "Menyentuh rambutmu saja terasa menyakitkan", 17, 23.5),
        ("いやでも", "akan tetapi", 23.5, 24),
        ("甘いな いやいや", "Begitu harum, tidak, tidak", 24, 26),
        
        ("グッバイ", "Selamat tinggal", 26, 27),
        ("それじ", "Kalau begitu", 27, 28),
        ("ゃ僕にとって君は何？", "Apakah artimu bagiku?", 28, 32),
        ("答えは分からない", "Aku tak mengetahui jawabannya", 32, 34.5),
        ("分かりたくもないのさ", "Aku juga tak ingin tahu jawabannya", 34.5, 38),
        ("たったひとつ", "Tapi satu hal yang pasti", 38, 40),
        ("確かなことがあるとするのならば", "Jika ada sesuatu yang pasti", 40, 46),
        ("「君は綺麗だ」", "Kau begitu cantik", 46, 51),
    ]

    font_path = "fonts/NotoSansJP-Regular.ttf"

    lyric_clips = generate_lyric_clip(lyrics, font_path)

    final = CompositeVideoClip([video, *lyric_clips])
    final = final.set_audio(audio)

    final.write_videofile('output_video_3.mp4', codec='libx264', fps=30)

if __name__ == "__main__":
    main()