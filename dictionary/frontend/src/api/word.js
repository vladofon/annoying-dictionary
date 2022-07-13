import { api } from '@/api/api-resource'

export default {
	create: word => api.post('words', word),
	edit: word => api.put(`words/${word.id}`, word),
	list: () => api.get('words'),
	get: id => api.get(`words/${id}`),
	getByValue: value => api.get(`words/find/${value}`),
	getSampleByValue: value => api.get(`words/find/${value}?limit=3`),
	delete: id => api.delete(`words/${id}`),
}