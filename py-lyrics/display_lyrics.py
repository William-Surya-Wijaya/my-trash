import os
from moviepy.editor import VideoFileClip, TextClip, CompositeVideoClip, AudioFileClip

def parse_bold_text(text, font_path, font_size, bold_font_path, color, duration):
    parts = text.split('*')
    clips = []
    start_time = 0

    for i, part in enumerate(parts):
        if part:
            font = bold_font_path if i % 2 == 1 else font_path
            clip = (TextClip(part, fontsize=font_size, font=font, color=color)
                    .set_duration(duration)
                    .set_start(start_time))
            clips.append(clip)
            start_time += duration

    return CompositeVideoClip(clips)

def generate_word_clips(sentence1, sentence2, start_time, duration, font_path, bold_font_path, font_size=72, color='white', position1=('center', 'center'), y_offset=50):
    words2 = sentence2.split()
    word_clips = []
    word_duration = duration / len(words2)

    sentence1_clip = (TextClip(sentence1, fontsize=font_size, font=font_path, color=color)
        .set_position(position1)
        .set_start(start_time)
        .set_duration(duration)
        .crossfadein(word_duration / 2))
    word_clips.append(sentence1_clip)

    video_height = 1080
    center_y = video_height // 2
    english_y_position = center_y + y_offset

    cumulative_sentence = ""
    for i, word in enumerate(words2):
        cumulative_sentence += word + " "
        bold_clip = TextClip(cumulative_sentence.strip(), fontsize=font_size, font=bold_font_path, color=color)
        bold_clip = bold_clip.set_position(('center', english_y_position)).set_start(start_time + i * word_duration).set_duration(word_duration).crossfadein(word_duration / 2)
        word_clips.append(bold_clip)

    return word_clips

def generate_lyric_clip(lyrics, font_path, bold_font_path, font_size=50, color='white'):
    clips = []
    for (text1, text2, start, end) in lyrics:
        duration = end - start
        word_clips = generate_word_clips(text1, text2, start, duration, font_path, bold_font_path, font_size, color)
        clips.extend(word_clips)
    return clips

def main():
    video = VideoFileClip('bg_mov.mp4')
    audio = AudioFileClip('audio.mp3')

    lyrics = [
        ("こんにちは", "watashi ga watashi no", 12, 13.5),
        ("私です", "koto o aishite", 13.5, 15),
        ("何が悪いの?", "nani ga warui no?", 15, 16.5),
        ("嫉妬でしょうか?", "shitto deshou ka?", 16.5, 18),
        ("痛いだとか", "itai da toka", 18, 19.5),
        ("変わってるとか", "kawatteru toka", 19.5, 21),
        ("届きませんね", "todokimasen ne", 21, 22.5),
        ("そのリプライ", "sono ripurai", 22.5, 24),
        ("大好きなお洋服", "daisuki na oyoufuku", 24, 26),
        ("大好きなお化粧で", "daisuki na okeshou de", 27, 29),
        ("お決まりのハーフツイン巻いて", "okimari no haafutsuin maite", 30, 34),
        ("お出かけしよ", "odekake shiyo", 34, 35.5),
        ("日傘持って", "higasa motte", 35.5, 37),
        ("ぼっちだって", "bocchi datte", 37, 38.5),
        ("幸せだもん!", "shiawase da mon!", 38.5, 42),

        ("Chu!", "Chu!", 42.5, 43),
        ("可愛くてごめん", "kawaikute gomen", 43, 45),
        ("生まれてきちゃってごめん", "umarete kichatte gomen", 45, 48),

        ("Chu!", "Chu!", 48.5, 49),
        ("あざとくてごめん", "azatokute gomen", 49, 51),
        ("気になっちゃうよね?", "ki ni nacchau yo ne?", 51, 53),
        ("ごめん", "gomen", 53, 54),

        ("Chu!", "Chu!", 54, 55),
        ("可愛くてごめん", "kawaikute gomen", 55, 56.6),
        ("努力し", "doryoku", 56.5, 57.5),
        ("ちゃっててごめん", "shichattete gomen", 57.5, 60),

        ("Chu!", "Chu!", 60.5, 61),
        ("尊くてごめん", "toutokute gomen", 61, 62.5),
        ("女子力", "joshiryoku", 62.5, 64),
        ("高くてごめん", "takakute gomen", 64, 66),
        ("ムカついちゃうよね?", "mukatsuichau yo ne?", 66, 68),
        ("ざまあ", "zamaa", 68, 70),

        ("OwO", "(music)", 70, 80),
    ]

    font_path = "fonts/NotoSansJP-Bold.ttf"
    bold_font_path = "fonts/NotoSansJP-Regular.ttf"

    lyric_clips = generate_lyric_clip(lyrics, font_path, bold_font_path)

    final = CompositeVideoClip([video, *lyric_clips])
    final = final.set_audio(audio)

    final.write_videofile('output_video_2.mp4', codec='libx264', fps=24)

if __name__ == "__main__":
    main()
