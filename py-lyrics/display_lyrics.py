from moviepy.editor import VideoFileClip, TextClip, CompositeVideoClip, AudioFileClip

def parse_bold_text(text, font_path, font_size, bold_font_path, color):
    parts = text.split('*')
    clips = []
    start_time = 0

    for i, part in enumerate(parts):
        if part:  # Skip empty parts
            font = bold_font_path if i % 2 == 1 else font_path
            clip = TextClip(part, fontsize=font_size, font=font, color=color).set_start(start_time)
            clips.append(clip)
            start_time += clip.duration

    return clips

def generate_word_clips(sentence1, sentence2, start_time, duration, font_path, bold_font_path, font_size=50, color='white', position1=('center', 'center'), y_offset=50):
    words2 = sentence2.split()
    word_clips = []
    word_duration = duration / len(words2)

    # Create clip for full Japanese sentence
    sentence1_clip = (TextClip(sentence1, fontsize=font_size, font=font_path, color=color)
                      .set_position(position1)
                      .set_start(start_time)
                      .set_duration(duration)
                      .crossfadein(word_duration / 2))
    word_clips.append(sentence1_clip)

    # Calculate the position for English text
    video_height = 1080  # Adjust this value based on your video's actual height
    center_y = video_height // 2
    english_y_position = center_y + y_offset

    # Create cumulative word clips for English sentence with bold styling
    cumulative_sentence = ""
    for i, word in enumerate(words2):
        cumulative_sentence += word + " "
        bold_clips = parse_bold_text(cumulative_sentence.strip(), font_path, font_size, bold_font_path, color)
        combined_clip = CompositeVideoClip(bold_clips).set_position(('center', english_y_position)).set_start(start_time + i * word_duration).set_duration(word_duration).crossfadein(word_duration / 2)
        word_clips.append(combined_clip)

    return word_clips

def generate_lyric_clip(lyrics, font_path, bold_font_path, font_size=50, color='white'):
    clips = []
    for (text1, text2, start, end) in lyrics:
        duration = end - start
        word_clips = generate_word_clips(text1, text2, start, duration, font_path, bold_font_path, font_size, color)
        clips.extend(word_clips)
    return clips

def main():
    video = VideoFileClip('bg_mov_1.mp4')
    audio = AudioFileClip('audio.mp3')

    lyrics = [
        ("*こんにちは*、私です", "watashi ga watashi no", 11, 13),
        ("こんにちは、私です", "koto o aishite", 13, 15),
        ("長い間、どうしているかと思っていました", "nani *ga* warui no?", 15, 16.5),
        ("長い間、どうしているかと思っていました", "shitto *deshou* ka?", 16.5, 18),
        ("痛いだとか 変わってるとか", "itai *da* toka", 18, 19.5),
        ("痛いだとか 変わってるとか", "kawatteru *toka*", 19.5, 21),
    ]

    font_path = "NotoSansJP-VariableFont_wght.ttf"
    bold_font_path = "NotoSansJP-Bold.ttf"  # Update with your bold font path

    # Generate text clips for the lyrics
    lyric_clips = generate_lyric_clip(lyrics, font_path, bold_font_path)

    # Composite the video and lyric clips
    final = CompositeVideoClip([video, *lyric_clips])
    final = final.set_audio(audio)

    # Write the result to a file
    final.write_videofile('output_video.mp4', codec='libx264', fps=24)

if __name__ == "__main__":
    main()
