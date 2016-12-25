/**
 * 
 */
package com.edu.service;

import java.util.List;
import java.util.Scanner;

import com.edu.dao.IAssess;
import com.edu.dao.ITeacher;
import com.edu.dao.impl.AssessImplMysql;
import com.edu.dao.impl.TeacherImplMysql;
import com.edu.dto.Teacher;

/**
 * @author 张明明 功能：删除评价信息，录入修改教师评价，查询教师评价，显示所有评价
 *
 */
public class AssessAiist {

	Scanner sc = new Scanner(System.in);
	IAssess assess = new AssessImplMysql();
	ITeacher teacher = new TeacherImplMysql();

	public void deleteAssess() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入删除评价的教师编号");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {
					System.out.println("教师等级\t教师评价");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());
					if (assess.deleteAssess(code)) {
						System.out.println("删除成功！");
					} else {
						System.out.println("删除失败！");
					}
				} else {
					System.out.println("你输入的教师编号不存在");
				}

				System.out.println("输入n或者N停止删除，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void modeifyAssess() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要修改的评价教师编号");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {
					System.out.println("教师等级\t教师评价");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());
					System.out.println("1：修改教师等级");
					System.out.println("2：修改教师评价信息");
					System.out.println("请进行选择");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						while (true) {
							System.out.println("请输入教师教学水平（1:A  2:B  3:C）");
							System.out.println("请进行选择：");
							key = sc.nextInt();
							switch (key) {
							case 1:
								tea.setMemo("A\t");
								break;
							case 2:
								tea.setMemo("B\t");
								break;
							case 3:
								tea.setMemo("C\t");
								break;

							default:
								System.out.println("不符合要求,请重新输入！！");
								continue;

							}
							break;
						}
						break;
					case 2:
						System.out.println("请你对教师的评价");
						tea.setWrite(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("教师编号不存在！");
				}
				if (assess.modify(tea)) {
					System.out.println("修改成功");
				} else {
					System.out.println(
							"修改失败！                                                                                                                                                               ");
				}

				System.out.println("输入n或者N停止修改，任意键继续");
				yes = sc.next();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void findAssess() throws Exception {

		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要查询评价的教师编号");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {

					System.out.println("教师等级\t教师评价");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());

				} else {
					System.out.println("教师编号不存在！");
				}

				System.out.println("输入n或者N停止查找，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void dispAllAssess() throws Exception {
		try {
			List<Teacher> sList = assess.lispAllAssess();
			System.out.println("教师姓名\t教师编号\t教师等级\t教师评价");
			for (int i = 0; i < sList.size(); i++) {
				System.out.println(sList.get(i).getName() + "\t" + sList.get(i).getNum() + "\t" + sList.get(i).getMemo()
						+ sList.get(i).getWrite());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void findMemoByTeacher(String tea_id) {
		try {
			Teacher tea = assess.findTeacherMeno(tea_id);
			if (tea != null) {
				System.out.println("教师等级\t\t教师评语");
				System.out.println(tea.getMemo() + "\t" + tea.getWrite());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
