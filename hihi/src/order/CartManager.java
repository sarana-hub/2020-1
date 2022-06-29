package order;

import java.util.Hashtable;

public class CartManager {
	
	private Hashtable<String, OrderBean> hCart = new Hashtable<String, OrderBean>();

	// īƮ�� �߰�

	public void addCart(OrderBean obean) {

		// key�� : product_no, value�� : OrderBean

		String product_no = obean.getProduct_no();

		int quantity = Integer.parseInt(obean.getQuantity());

		// �ֹ������� 0���� ũ��

		if (quantity > 0) {

			// īƮ�� ���ϻ�ǰ�� ������

			if (hCart.containsKey(product_no)) {

				// īƮ�� ���� ��ǰ��ȣ�� orderbean�� ������

				OrderBean tempBean = (OrderBean) hCart.get(product_no);

				// ���� ���� + ���� ��ǰ�� ����

				quantity += Integer.parseInt(tempBean.getQuantity());

				// ������ǰ ���� = ���簹�� + ������ǰ ����

				tempBean.setQuantity(Integer.toString(quantity));

				// īƮ�� �߰�

				hCart.put(product_no, tempBean);

				// īƮ�� ���ϻ�ǰ�� ������

			} else {

				hCart.put(product_no, obean);

			}

		}

	}

	// īƮ ��� ���

	public Hashtable<String, OrderBean> getCartList() {

		return hCart;

	}

	// īƮ ���� ����

	public void updateCart(OrderBean obean) {

		String product_no = obean.getProduct_no();

		hCart.put(product_no, obean);

	}

	// īƮ ���� ����

	public void deleteCart(OrderBean obean) {

		String product_no = obean.getProduct_no();

		hCart.remove(product_no);

	}

}
