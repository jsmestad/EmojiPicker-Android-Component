/*
 * Created by Coffee IT
 *
 * MIT License
 *
 * Copyright (c) 2022 Coffee IT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.coffeeit.aroma.emojipicker.domain.model

import com.google.gson.annotations.SerializedName
import nl.coffeeit.aroma.emojipicker.util.UNICODE_HEX_PREFIX
import java.util.*

data class EmojiItem(
  @SerializedName("emoji") val emoji: String,
  @SerializedName("name") val name: String,
  @SerializedName("slug") val slug: String
) {
  val unicode get() = run {
    val stringBuilder = StringBuilder()
    var offset = 0
    while (offset < emoji.length) {
      val codePoint = emoji.codePointAt(offset)
      stringBuilder.append(UNICODE_HEX_PREFIX + Integer.toHexString(codePoint).uppercase(Locale.getDefault()))
      offset += Character.charCount(codePoint)
    }
    stringBuilder.toString()
  }
}