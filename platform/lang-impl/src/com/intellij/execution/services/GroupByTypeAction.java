// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.execution.services;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.openapi.project.DumbAware;
import org.jetbrains.annotations.NotNull;

import static com.intellij.execution.services.ServiceViewActionProvider.getSelectedView;

public class GroupByTypeAction extends ToggleAction implements DumbAware {
  @Override
  public void update(@NotNull AnActionEvent e) {
    super.update(e);
    ServiceView selectedView = getSelectedView(e);
    e.getPresentation().setEnabled(selectedView != null && !selectedView.isFlat());
  }

  @Override
  public boolean isSelected(@NotNull AnActionEvent e) {
    ServiceView selectedView = getSelectedView(e);
    return selectedView != null && selectedView.isGroupByType();
  }

  @Override
  public void setSelected(@NotNull AnActionEvent e, boolean state) {
    ServiceView selectedView = getSelectedView(e);
    if (selectedView != null) {
      selectedView.setGroupByType(state);
    }
  }
}
