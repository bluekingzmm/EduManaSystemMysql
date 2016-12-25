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
 * @author ������ ���ܣ�ɾ��������Ϣ��¼���޸Ľ�ʦ���ۣ���ѯ��ʦ���ۣ���ʾ��������
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
				System.out.println("������ɾ�����۵Ľ�ʦ���");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {
					System.out.println("��ʦ�ȼ�\t��ʦ����");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());
					if (assess.deleteAssess(code)) {
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("������Ľ�ʦ��Ų�����");
				}

				System.out.println("����n����Nֹͣɾ�������������");
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
				System.out.println("��������Ҫ�޸ĵ����۽�ʦ���");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {
					System.out.println("��ʦ�ȼ�\t��ʦ����");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());
					System.out.println("1���޸Ľ�ʦ�ȼ�");
					System.out.println("2���޸Ľ�ʦ������Ϣ");
					System.out.println("�����ѡ��");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						while (true) {
							System.out.println("�������ʦ��ѧˮƽ��1:A  2:B  3:C��");
							System.out.println("�����ѡ��");
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
								System.out.println("������Ҫ��,���������룡��");
								continue;

							}
							break;
						}
						break;
					case 2:
						System.out.println("����Խ�ʦ������");
						tea.setWrite(sc.next());
						break;

					default:
						break;
					}

				} else {
					System.out.println("��ʦ��Ų����ڣ�");
				}
				if (assess.modify(tea)) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println(
							"�޸�ʧ�ܣ�                                                                                                                                                               ");
				}

				System.out.println("����n����Nֹͣ�޸ģ����������");
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
				System.out.println("��������Ҫ��ѯ���۵Ľ�ʦ���");
				String code = sc.next();
				Teacher tea = assess.findAssess(code);
				if (tea != null) {

					System.out.println("��ʦ�ȼ�\t��ʦ����");
					System.out.println(tea.getMemo() + "\t" + tea.getWrite());

				} else {
					System.out.println("��ʦ��Ų����ڣ�");
				}

				System.out.println("����n����Nֹͣ���ң����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void dispAllAssess() throws Exception {
		try {
			List<Teacher> sList = assess.lispAllAssess();
			System.out.println("��ʦ����\t��ʦ���\t��ʦ�ȼ�\t��ʦ����");
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
				System.out.println("��ʦ�ȼ�\t\t��ʦ����");
				System.out.println(tea.getMemo() + "\t" + tea.getWrite());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
