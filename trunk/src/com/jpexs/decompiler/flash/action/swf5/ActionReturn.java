/*
 *  Copyright (C) 2010-2013 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.decompiler.flash.action.swf5;

import com.jpexs.decompiler.flash.action.Action;
import com.jpexs.decompiler.flash.action.treemodel.ReturnTreeItem;
import com.jpexs.decompiler.flash.graph.GraphTargetItem;
import java.util.List;
import java.util.Stack;

public class ActionReturn extends Action {

   public ActionReturn() {
      super(0x3E, 0);
   }

   @Override
   public String toString() {
      return "Return";
   }

   @Override
   public void translate(Stack<GraphTargetItem> stack, List<GraphTargetItem> output, java.util.HashMap<Integer, String> regNames) {
      GraphTargetItem value = stack.pop();
      output.add(new ReturnTreeItem(this, value));
   }

   @Override
   public boolean isExit() {
      return true;
   }
}
