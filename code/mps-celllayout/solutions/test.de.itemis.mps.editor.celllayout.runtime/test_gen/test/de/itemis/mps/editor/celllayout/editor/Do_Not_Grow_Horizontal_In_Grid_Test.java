package test.de.itemis.mps.editor.celllayout.editor;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.ide.ThreadUtils;
import de.itemis.mps.editor.celllayout.runtime.LayoutInterceptor;
import jetbrains.mps.openapi.editor.cells.EditorCell;
import jetbrains.mps.openapi.editor.cells.EditorCell_Collection;
import junit.framework.Assert;

@MPSLaunch
public class Do_Not_Grow_Horizontal_In_Grid_Test extends BaseTransformationTest {
  @Test
  public void test_Do_Not_Grow_Horizontal_In_Grid() throws Throwable {
    initTest("${mbeddr.github.core.home}/code/plugins/sl-all", "r:ee6cf12e-fe83-4365-8111-77ef29f91ab7(test.de.itemis.mps.editor.celllayout.editor@tests)");
    runTest("test.de.itemis.mps.editor.celllayout.editor.Do_Not_Grow_Horizontal_In_Grid_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    @Override
    public void testMethodImpl() throws Exception {
      initEditorComponent("492440529733473522", "");

      final EditorComponent editorComponent = getEditorComponent();
      ThreadUtils.runInUIThreadAndWait(new Runnable() {
        public void run() {
          LayoutInterceptor.install(editorComponent);
          editorComponent.relayout();
        }
      });

      // Collection >Vertical 
      EditorCell cell0 = editorComponent.getRootCell();
      // Collection >Horizontal 
      EditorCell cell0_0 = ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(0);
      // aaaaaaaaaaaaaa 
      EditorCell aaaaaaaaaaaaaa = ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(0)).getCellAt(0);
      // bbbbbbbbb 
      EditorCell bbbbbbbbb = ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(0)).getCellAt(1);
      // Collection >Horizontal 
      EditorCell cell0_1 = ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(1);
      // Collection >Horizontal 
      EditorCell cell0_1_0 = ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(1)).getCellAt(0);
      // ccc 
      EditorCell ccc = ((EditorCell_Collection) ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(1)).getCellAt(0)).getCellAt(0);
      // ddd 
      EditorCell ddd = ((EditorCell_Collection) ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(1)).getCellAt(0)).getCellAt(1);
      // eee 
      EditorCell eee = ((EditorCell_Collection) ((EditorCell_Collection) editorComponent.getRootCell()).getCellAt(1)).getCellAt(1);

      int c_d_gap = ddd.getX() - (ccc.getX() + ccc.getWidth());
      int a_b_gap = bbbbbbbbb.getX() - (aaaaaaaaaaaaaa.getX() + aaaaaaaaaaaaaa.getWidth());
      Assert.assertEquals(a_b_gap, c_d_gap);
      Assert.assertEquals(ddd.getLeftGap(), bbbbbbbbb.getLeftGap());
      Assert.assertEquals(aaaaaaaaaaaaaa.getRightGap(), ccc.getRightGap());
    }
  }
}