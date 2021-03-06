/*
 * Copyright (C) 2007-2010 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package ua.pocketbook.fb2viewer.zlibrary.text.view.style;


import ua.pocketbook.fb2viewer.zlibrary.core.options.*;
import ua.pocketbook.fb2viewer.zlibrary.text.model.ZLTextAlignmentType;
import ua.pocketbook.fb2viewer.zlibrary.text.view.ZLTextHyperlink;
import ua.pocketbook.fb2viewer.zlibrary.text.view.ZLTextStyle;
import ua.pocketbook.reader.ReaderActivity;

public class ZLTextBaseStyle extends ZLTextStyle {
	private static final String GROUP = "Style";
	private static final String OPTIONS = "Options";

	public final ZLBooleanOption AutoHyphenationOption =
		new ZLBooleanOption(OPTIONS, "AutoHyphenation", true);

	public final ZLBooleanOption BoldOption =
		new ZLBooleanOption(GROUP, "Base:bold", false);
	public final ZLBooleanOption ItalicOption =
		new ZLBooleanOption(GROUP, "Base:italic", false);
	public final ZLBooleanOption UnderlineOption =
		new ZLBooleanOption(GROUP, "Base:underline", false);
	public final ZLIntegerOption AlignmentOption =
		new ZLIntegerOption(GROUP, "Base:alignment", ZLTextAlignmentType.ALIGN_JUSTIFY);
	public final ZLIntegerOption LineSpacePercentOption =
		new ZLIntegerOption(GROUP, "Base:lineSpacingPercent", 120);

	public final ZLStringOption FontFamilyOption;
	public final ZLIntegerRangeOption FontSizeOption;
	
	public ZLTextBaseStyle(String fontFamily, int fontSize) {
		super(null, ZLTextHyperlink.NO_LINK);
		FontFamilyOption = new ZLStringOption(GROUP, "Base:fontFamily", fontFamily);
		FontSizeOption = new ZLIntegerRangeOption(GROUP, "Base:fontSize", 0, 72, fontSize);
	}
	
	@Override
	public String getFontFamily() {
		return FontFamilyOption.getValue();
	}

	@Override
	public int getFontSize() {
		//return FontSizeOption.getValue();
		return ReaderActivity.instance.readerPreferences.getFontSize();
	}

	@Override
	public boolean isBold() {
		return BoldOption.getValue();
	}

	@Override
	public boolean isItalic() {
		return ItalicOption.getValue();
	}

	@Override
	public boolean isUnderline() {
		return UnderlineOption.getValue();
	}

	@Override
	public int getLeftIndent() {
		return 0;
	}

	@Override
	public int getRightIndent() {
		return 0;
	}

	@Override
	public int getFirstLineIndentDelta() {
		return 0;
	}
	
	@Override
	public int getLineSpacePercent() {
		return LineSpacePercentOption.getValue();
	}

	@Override
	public int getVerticalShift() {
		return 0;
	}

	@Override
	public int getSpaceBefore() {
		return 0;
	}

	@Override
	public int getSpaceAfter() {
		return 0;
	}

	@Override
	public byte getAlignment() {
		return (byte)AlignmentOption.getValue();
	}

	@Override
	public boolean allowHyphenations() {
		return true;
	}
}
