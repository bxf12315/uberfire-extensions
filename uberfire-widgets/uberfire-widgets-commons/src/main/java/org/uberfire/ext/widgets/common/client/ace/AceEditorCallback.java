// Copyright (c) 2011 David H. Hovemeyer <david.hovemeyer@gmail.com>
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package org.uberfire.ext.widgets.common.client.ace;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Callback interface for events generated by {@link AceEditor}.
 * Note that the argument the callback receives is a
 * JavaScriptObject, so you will probably need to use JSNI to
 * make use of it.
 */
public interface AceEditorCallback {
	/**
	 * Callback method.
	 * 
	 * @param obj the event object: for example, an onChange event
	 *            if this callback is receiving onChange events
	 */
	public void invokeAceCallback( JavaScriptObject obj );
}