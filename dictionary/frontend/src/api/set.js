import { api } from '@/api/api-resource'

export default {
	create: set => api.post('sets', set),
	edit: set => api.put(`sets/${set.id}`, set),
	list: () => api.get('sets'),
	get: id => api.get(`sets/${id}`),
	delete: id => api.delete(`sets/${id}`)
}