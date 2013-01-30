/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package at.pollux.thymeleaf.shiro.processor;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;

public abstract class InvertVisibilityAttrProcessor<T extends IConditionalVisibilityAttrProcessor> extends AbstractConditionalVisibilityAttrProcessor implements IConditionalVisibilityAttrProcessor {

    private final T delegate;

    public InvertVisibilityAttrProcessor(final String attributeName, final T delegate) {
        super(attributeName);
        this.delegate = delegate;
    }

    @Override
    public int getPrecedence() {
        return delegate.getPrecedence();
    }

    @Override
    public boolean isVisible(final Arguments arguments, final Element element, final String attributeName) {
        return !delegate.isVisible(arguments, element, attributeName);
    }
}