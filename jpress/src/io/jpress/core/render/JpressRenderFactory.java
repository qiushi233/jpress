/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.core.render;

import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.Render;

import io.jpress.core.Jpress;

public class JpressRenderFactory implements IMainRenderFactory {

	public JpressRenderFactory() {
	}

	@Override
	public Render getRender(String view) {
		// front url
		if (view.startsWith("/templates")) {
			String renderType = Jpress.currentTemplate().getRenderType();
			if ("thymeleaf".equalsIgnoreCase(renderType)) {
				return new ThymeleafRender(view);
			} else if ("freemarker".equalsIgnoreCase(renderType)) {
				return new JFreemarkerRender(view);
			}
		}

		//admin url
		return new JFreemarkerRender(view);
	}

	@Override
	public String getViewExtension() {
		return ".html";
	}

}
