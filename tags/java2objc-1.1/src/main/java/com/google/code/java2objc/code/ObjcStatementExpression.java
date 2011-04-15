/*
 * Copyright (C) 2009 Inderjeet Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.java2objc.code;

import com.googlecode.java2objc.objc.CompilationContext;
import com.googlecode.java2objc.objc.SourceCodeWriter;

import japa.parser.ast.stmt.ExpressionStmt;

/**
 * An Objective C statement that consists of a single expression. Some examples of expression
 * statements are: 
 * <ul>
 * <li> ++i; </li>
 * <li> a*b; </li>
 * <li> a * foo:(NSInteger) a;</li>
 * </ul>
 * 
 * @author Inderjeet Singh
 */
public final class ObjcStatementExpression extends ObjcStatement {

  private final ObjcExpression expr;

  public ObjcStatementExpression(CompilationContext context, ExpressionStmt stmt) {
    this(context.getExpressionConverter().to(stmt.getExpression()));
  }

  public ObjcStatementExpression(ObjcExpression expr) {
    this.expr = expr;
  }

  public ObjcExpression getExpression() {
    return expr;
  }

  @Override
  public void append(SourceCodeWriter writer) {
    writer.append(expr).endStatement();
  }
}
